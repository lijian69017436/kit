package com.zbxsoft.core.orm.hibernate;

import com.zbxsoft.core.utils.ReflectionUtils;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.Assert;

public class HibernateUtils {
	public static <T, ID> void mergeByCheckedIds(Collection<T> srcObjects, Collection<ID> checkedIds, Class<T> clazz) {
		mergeByCheckedIds(srcObjects, checkedIds, clazz, "id");
	}

	public static <T, ID> void mergeByCheckedIds(Collection<T> srcObjects, Collection<ID> checkedIds, Class<T> clazz,
			String idName) {
		Assert.notNull(srcObjects, "scrObjects不能为空");
		Assert.hasText(idName, "idName不能为空");
		Assert.notNull(clazz, "clazz不能为空");

		if (checkedIds == null) {
			srcObjects.clear();
			return;
		}

		Iterator srcIterator = srcObjects.iterator();
		try {
			while (srcIterator.hasNext()) {
				Object element = srcIterator.next();

				Object id = PropertyUtils.getProperty(element, idName);

				if (!checkedIds.contains(id))
					srcIterator.remove();
				else {
					checkedIds.remove(id);
				}

			}

			for (Iterator iter = checkedIds.iterator(); iter.hasNext();) {
				Object id = iter.next();
				T obj = clazz.newInstance();
				PropertyUtils.setProperty(obj, idName, id);
				srcObjects.add( obj);
			}
		} catch (Exception e) {
			Iterator i$;
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
	}
}
