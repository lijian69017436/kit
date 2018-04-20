package com.zbxsoft.core.utils;

import java.security.SecureRandom;
import java.util.UUID;

public abstract class IdUtils {
	private static SecureRandom random = new SecureRandom();

	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	public static long randomLong() {
		return random.nextLong();
	}

	public static String randomBase62() {
		return EncodeUtils.encodeBase62(random.nextLong());
	}
}
