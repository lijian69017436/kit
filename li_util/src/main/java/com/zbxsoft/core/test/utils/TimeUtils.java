package com.zbxsoft.core.test.utils;

import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeUtils {
	private static Logger logger = LoggerFactory.getLogger(TimeUtils.class);

	private static Stack<Long> times = new Stack();

	public static void begin() {
		times.add(Long.valueOf(System.currentTimeMillis()));
	}

	public static void end(String title) {
		String message = title + " : " + (System.currentTimeMillis() - ((Long) times.pop()).longValue());
		logger.info(message);
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
