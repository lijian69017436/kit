package com.zbxsoft.core.utils;

public class ExceptionUtils {
	public static RuntimeException unchecked(Exception e) {
		if ((e instanceof RuntimeException)) {
			return (RuntimeException) e;
		}
		return new RuntimeException(e.getMessage(), e);
	}
}
