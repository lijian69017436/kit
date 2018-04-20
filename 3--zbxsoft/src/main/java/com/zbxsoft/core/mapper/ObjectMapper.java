package com.zbxsoft.core.mapper;

import com.google.common.collect.Lists;
import com.zbxsoft.core.utils.ReflectionUtils;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.velocity.util.StringUtils;
import org.dozer.DozerBeanMapper;

public abstract class ObjectMapper {
	private static DozerBeanMapper dozer = new DozerBeanMapper();

	public static <T> T map(Object source, Class<T> destinationClass) {
		return dozer.map(source, destinationClass);
	}

	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
		List destinationList = Lists.newArrayList();
		for (Iterator i$ = sourceList.iterator(); i$.hasNext();) {
			Object sourceObject = i$.next();
			Object destinationObject = dozer.map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}

	public static void registerDateConverter(String patterns) {
		DateConverter dc = new DateConverter();
		dc.setUseLocaleFormat(true);
		dc.setPatterns(StringUtils.split(patterns, ","));
		ConvertUtils.register(dc, Date.class);
	}

	public static Object convertToObject(String value, Class<?> toType) {
		try {
			return ConvertUtils.convert(value, toType);
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
	}

	static {
		registerDateConverter("yyyy-MM-dd,yyyy-MM-dd HH:mm:ss");
	}
}
