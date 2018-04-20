package com.zbxsoft.core.mapper;

import com.zbxsoft.core.utils.ReflectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public class CollectionMapper {
	/**
	 * 提取 集合中对象 属性值 ,转换为map
	 * @param collection 集合
	 * @param keyPropertyName 对象其中一个字段 作为map的key
	 * @param valuePropertyName 对象其中一个字段 做完map的value
	 * @return
	 */
	public static Map extractToMap(Collection collection, String keyPropertyName, String valuePropertyName) {
		Map map = new HashMap();
		try {

			for (Iterator d = collection.iterator(); d.hasNext();) {
				Object obj = d.next();
				//得到 这个对象属性的 值
				map.put(PropertyUtils.getProperty(obj, keyPropertyName),
						PropertyUtils.getProperty(obj, valuePropertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}

	/**
	 * 提取 集合中 所有对象其中一个值  重新添加为list
	 * @param collection
	 * @param propertyName 要提取的 字段
	 * @return
	 */
	public static List extractToList(Collection collection, String propertyName) {
		List list = new ArrayList();
		try {
			for (Iterator iter = collection.iterator(); iter.hasNext();) {
				Object obj = iter.next();
				list.add(PropertyUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return list;
	}

	/**
	 * 提取 集合中的  数据 拼成  string 字符串
	 * @param collection
	 * @param propertyName 需要对象的字段 名
	 * @param separator 组成新字符串的 分割符
	 * @return
	 */
	public static String extractToString(Collection collection, String propertyName, String separator) {
		List list = extractToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}
}
