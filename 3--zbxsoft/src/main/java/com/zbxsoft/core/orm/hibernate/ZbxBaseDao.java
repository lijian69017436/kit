package com.zbxsoft.core.orm.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.util.Assert;

import com.zbxsoft.core.orm.Page;
import com.zbxsoft.core.orm.PropertyFilter;
import com.zbxsoft.core.utils.ReflectionUtils;

@SuppressWarnings("rawtypes")
public class ZbxBaseDao<T, PK extends Serializable> extends ZbxGenericDao<T, PK> {
	public ZbxBaseDao() {
	}

	public ZbxBaseDao(SessionFactory sessionFactory, Class<T> entityClass) {
		super(sessionFactory, entityClass);
	}

	public Page<T> getAll(Page<T> page) {
		return findPage(page, new Criterion[0]);
	}

	/**
	 * 查找分页 根据 list
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	public Page<T> findPage(Page<T> page, String hql, Object[] values) {
		Assert.notNull(page, "page不能为空");

		Query q = createQuery(hql, values);

		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameterToQuery(q, page);
		List result = q.list();
		page.setResult(result);
		return page;
	}

	/**
	 * 查询分页 根据 map
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 *            条件key:value
	 * @return
	 */
	public Page<T> findPage(Page<T> page, String hql, Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");

		Query q = createQuery(hql, values);

		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameterToQuery(q, page);

		List result = q.list();
		page.setResult(result);
		return page;
	}

	/**
	 * 查询全部
	 * 
	 * @param page
	 * @param criterions
	 * @return
	 */
	public Page<T> findPage(Page<T> page, Criterion[] criterions) {
		Assert.notNull(page, "page不能为空");

		Criteria c = createCriteria(criterions);

		if (page.isAutoCount()) {
			long totalCount = countCriteriaResult(c);
			page.setTotalCount(totalCount);
		}

		setPageParameterToCriteria(c, page);

		List result = c.list();
		page.setResult(result);
		return page;
	}

	/**
	 * 设置分页 参数 到查询语句
	 * 
	 * @param q
	 * @param page
	 * @return
	 */
	protected Query setPageParameterToQuery(Query q, Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");

		q.setFirstResult(page.getFirst() - 1);
		q.setMaxResults(page.getPageSize());
		return q;
	}

	/**
	 * 设置page 参数到  criteria
	 * @param c
	 * @param page
	 * @return
	 */
	protected Criteria setPageParameterToCriteria(Criteria c, Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");

		c.setFirstResult(page.getFirst() - 1);
		c.setMaxResults(page.getPageSize());

		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');

			Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

			for (int i = 0; i < orderByArray.length; i++) {
				if ("asc".equals(orderArray[i]))
					c.addOrder(Order.asc(orderByArray[i]));
				else {
					c.addOrder(Order.desc(orderByArray[i]));
				}
			}
		}
		return c;
	}
	/**
	 * 计算 数据总数  根据list
	 * @param hql
	 * @param values
	 * @return
	 */
	protected long countHqlResult(String hql, Object[] values) {
		String countHql = prepareCountHql(hql);
		try {
			Long count = (Long) findUnique(countHql, values);
			return count.longValue();
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	/**
	 * 计算数据总数 根据map
	 * @param hql
	 * @param values
	 * @return
	 */
	protected long countHqlResult(String hql, Map<String, ?> values) {
		String countHql = prepareCountHql(hql);
		try {
			Long count = (Long) findUnique(countHql, values);
			return count.longValue();
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	/**
	 *  准备 count 语句
	 * @param orgHql
	 * @return
	 */
	private String prepareCountHql(String orgHql) {
		String fromHql = orgHql;

		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");//把from 前边的删除
		fromHql = StringUtils.substringBefore(fromHql, "order by"); //把order 后边的删除

		String countHql = "select count(*) " + fromHql;
		return countHql;
	}

	/**
	 * 计算一张表 总数
	 * @param c
	 * @return
	 */
	protected long countCriteriaResult(Criteria c) {
		CriteriaImpl impl = (CriteriaImpl) c;

		Projection projection = impl.getProjection();
		ResultTransformer transformer = impl.getResultTransformer();

		List orderEntries = null;
		try {
			orderEntries = (List) ReflectionUtils.getFieldValue(impl, "orderEntries");
			ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			this.logger.error("不可能抛出的异常:{}", e.getMessage());
		}

		Object obj = c.setProjection(Projections.rowCount()).uniqueResult();
		if (obj == null)
			obj = "0";
		Long totalCountObject = Long.valueOf(obj.toString());
		long totalCount = totalCountObject != null ? totalCountObject.longValue() : 0L;

		c.setProjection(projection);

		if (projection == null) {
			c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (transformer != null)
			c.setResultTransformer(transformer);
		try {
			ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			this.logger.error("不可能抛出的异常:{}", e.getMessage());
		}

		return totalCount;
	}

	/**
	 * 根据 传入的 matchtype类型 来构造 条件语句    = > < 等
	 * @param propertyName
	 * @param value
	 * @param matchType
	 * @return
	 */
	public List<T> findBy(String propertyName, Object value, PropertyFilter.MatchType matchType) {
		Criterion criterion = buildCriterion(propertyName, value, matchType);
		return find(new Criterion[] { criterion });
	}

	public List<T> find(List<PropertyFilter> filters) {
		Criterion[] criterions = buildCriterionByPropertyFilter(filters);
		return find(criterions);
	}

	public Page<T> findPage(Page<T> page, List<PropertyFilter> filters) {
		Criterion[] criterions = buildCriterionByPropertyFilter(filters);
		return findPage(page, criterions);
	}

	/**
	 *  根据 matchtype 类型来构造 条件语句
	 * @param propertyName
	 * @param propertyValue
	 * @param matchType
	 * @return
	 */
	protected Criterion buildCriterion(String propertyName, Object propertyValue, PropertyFilter.MatchType matchType) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = null;

		switch (matchType.ordinal()+1) {
		case 1:
			criterion = Restrictions.eq(propertyName, propertyValue);
			break;
		case 2:
			criterion = Restrictions.like(propertyName, (String) propertyValue, MatchMode.ANYWHERE);
			break;
		case 3:
			criterion = Restrictions.lt(propertyName, propertyValue);
			break;
		case 4:
			criterion = Restrictions.gt(propertyName, propertyValue);
			break;
		case 5:
			criterion = Restrictions.le(propertyName, propertyValue);
			break;
		case 6:
			criterion = Restrictions.ge(propertyName, propertyValue);
		}
		return criterion;
	}
	//没有例子 不好看 没看
	protected Criterion[] buildCriterionByPropertyFilter(List<PropertyFilter> filters) {
		List criterionList = new ArrayList();
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) {
				Criterion criterion = buildCriterion(filter.getPropertyName(), filter.getMatchValue(),
						filter.getMatchType());

				criterionList.add(criterion);
			} else {
				Disjunction disjunction = Restrictions.disjunction();
				for (String param : filter.getPropertyNames()) {
					Criterion criterion = buildCriterion(param, filter.getMatchValue(), filter.getMatchType());
					disjunction.add(criterion);
				}
				criterionList.add(disjunction);
			}
		}
		return (Criterion[]) criterionList.toArray(new Criterion[criterionList.size()]);
	}

	public boolean isPropertyUnique(String propertyName, Object newValue, Object oldValue) {
		if ((newValue == null) || (newValue.equals(oldValue))) {
			return true;
		}
		Object object = findUniqueBy(propertyName, newValue);
		return object == null;
	}

	/**
	 * 根据sql 分页查询结果 
	 * @param sql
	 * @param pageSize
	 * @param pageNumber
	 * @return 反回map类型
	 */
	public Page getMapPageListBySql(String sql, int pageSize, int pageNumber) {
		return getPageListBySql(sql, pageSize, pageNumber, HashMap.class);
	}

	/**
	 * 根据 sql 分页查询结果
	 * @param sql
	 * @param pageSize 几条
	 * @param pageNum 几页
	 * @param modeClass 反回类型
	 * @return class 自定义类型
	 */
	public Page getPageListBySql(String sql, int pageSize, int pageNum, Class modeClass) {
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setPageNo(pageNum);

		String countSql = "select count(*) as count from (" + sql + ") count_temp ";

		int count = getCountByCountSQL(countSql);

		if (count < 1) {
			List list = new ArrayList();
			page.setResult(list);
			page.setTotalCount(0L);
			return page;
		}

		pageSize = pageSize > 0 ? pageSize : 15;
		pageNum = pageNum > 0 ? pageNum : 1;

		int firstResult = (pageNum - 1) * pageSize;
		int maxResult = pageSize;

		List resultList = getList(sql, firstResult, maxResult, modeClass);

		page.setResult(resultList == null ? new ArrayList() : resultList);
		page.setTotalCount(count);
		return page;
	}

	public int getCountByCountHQL(String hql) {
		return getCountByCountSql(hql, true);
	}

	public int getCountByCountSQL(String sql) {
		return getCountByCountSql(sql, false);
	}

	// 计算 count 总数
	private int getCountByCountSql(String queryStr, boolean isHSQL) {
		String sql = queryStr;
		String result = "0";
		Session session = getSession();
		if (isHSQL) {
			result = String.valueOf(session.createQuery(sql).iterate().next());
		} else {
			result = String.valueOf(session.createSQLQuery(sql).uniqueResult());
		}

		return new Integer(result).intValue();
	}

	
	//  根据sql 最低层 分页查询
	private List getList(String sql, int firstResult, int maxResult, Class pojoClass) {
		SQLQuery query = getSession().createSQLQuery(sql);

		if (firstResult >= 0) { 
			query.setFirstResult(firstResult);
		}

		if (maxResult > 0) {
			query.setMaxResults(maxResult);
		}

		List resultList = null;

		if ((pojoClass != null) || (pojoClass != HashMap.class)) {
			resultList = query.setResultTransformer(new ToBeanResultTransformSafety(pojoClass)).list();
		}

		query = null;

		return resultList;
	}
}
