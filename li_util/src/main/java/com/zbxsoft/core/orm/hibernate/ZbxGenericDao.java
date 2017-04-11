package com.zbxsoft.core.orm.hibernate;

import com.zbxsoft.core.utils.ReflectionUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ZbxGenericDao<T, PK extends Serializable> {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected SessionFactory sessionFactory;
	protected Class<T> entityClass;

	public ZbxGenericDao() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}

	public ZbxGenericDao(SessionFactory sessionFactory, Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Autowired //设置session factory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		// return this.sessionFactory.getCurrentSession(); //当前线程的session
		return this.sessionFactory.openSession(); // java代码的session
	}

	public void save(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().save(entity);
		this.logger.debug("save entity: {}", entity);
	}
	
	public void update(T entity){
		Assert.notNull(entity, "entity不能为空");
		getSession().update(entity);
		this.logger.debug("update entity: {}", entity);
	}
	
	public void delete(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().delete(entity);
		this.logger.debug("delete entity: {}", entity);
	}

	public void delete(PK id) {
		Assert.notNull(id, "id不能为空");
		delete(get(id));
		this.logger.debug("delete entity {},id is {}", this.entityClass.getSimpleName(), id);
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Assert.notNull(id, "id不能为空");
		return (T) getSession().get(this.entityClass, id);
	}

	public T load(PK id) {
		Assert.notNull(id, "id不能为空");
		return (T) getSession().load(this.entityClass, id);
	}

	/**
	 * 得到 所有数据
	 * @return
	 */
	public List<T> getAll() {
		return find(new Criterion[0]);
	}

	/**得到所有 数据 
	 * @param orderBy 排序字段
	 * @param isAsc  是否排序
	 * @return
	 */
	public List<T> getAll(String orderBy, boolean isAsc) {
		Criteria c = createCriteria(new Criterion[0]);
		if (isAsc)
			c.addOrder(Order.asc(orderBy));
		else {
			c.addOrder(Order.desc(orderBy));
		}
		return c.list();
	}

	/**
	 * 查询  字段=value 的所有数据
	 * @param propertyName 字段名
	 * @param value   字段值
	 * @return
	 */
	public List<T> findBy(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(new Criterion[] { criterion });
	}

	/**
	 * 查询  字段=value 的数据  结果只有一个
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findUniqueBy(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(new Criterion[] { criterion }).uniqueResult();
	}

	/**
	 * @根据多个id查询数据
	 * @param ids
	 * @return
	 */
	public List<T> findByIds(List<PK> ids) {
		return find(new Criterion[] { Restrictions.in(getIdName(), ids) });
	}

	/**
	 * @根据hql.values值.查询.数据
	 * @param hql
	 * @param values
	 * @return
	 */
	public <X> List<X> find(String hql, Object[] values) {
		return createQuery(hql, values).list();
	}

	public <X> List<X> find(String hql, Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	public <X> X findUnique(String hql, Object[] values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	public <X> X findUnique(String hql, Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * 执行更新
	 * @param hql
	 * @param values
	 * @return
	 */
	public int batchExecute(String hql, Object[] values) {
		return createQuery(hql, values).executeUpdate();
	}

	public int batchExecute(String hql, Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}

	/**
	 * 创建 hql查询语句
	 * @param queryString
	 * @param values
	 * @return
	 */
	public Query createQuery(String queryString, Object[] values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	/**
	 * 创建  hql查询语句
	 * @param queryString
	 * @param values
	 * @return
	 */
	public Query createQuery(String queryString, Map<String, ?> values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}

	public List<T> find(Criterion[] criterions) {
		return createCriteria(criterions).list();
	}

	public T findUnique(Criterion[] criterions) {
		return (T) createCriteria(criterions).uniqueResult();
	}

	public Criteria createCriteria(Criterion[] criterions) {
		Criteria criteria = getSession().createCriteria(this.entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/**原理: 因为lazy 延迟加载 是全局的   现在想局部变成 不延迟加载 就需要用到这个方法 
	 * 强制加载    
	 * @param entity
	 */
	public void initEntity(T entity) {
		Hibernate.initialize(entity);
	}

	/**原理: 因为lazy 延迟加载 是全局的   现在想局部变成 不延迟加载 就需要用到这个方法 
	 * 强制加载    
	 */
	public void initEntity(List<T> entityList) {
		for (Iterator i$ = entityList.iterator(); i$.hasNext();) {
			Object entity = i$.next();
			Hibernate.initialize(entity);
		}
	}

	public void flush() {
		getSession().flush();
	}

	/**
	 * 用于将数据库查询到的数据打包成临时的包装类
	 * @param query
	 * @return
	 */
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	/**
	 * 用于将数据库查询到的数据打包成临时的包装类
	 * @param criteria
	 * @return
	 */
	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	/**
	 * 得到 主键 字段名字
	 * @return
	 */
	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(this.entityClass);
		return meta.getIdentifierPropertyName();
	}
}
