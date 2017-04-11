package com.zbxsoft.core.utils.security;

import com.zbxsoft.core.utils.EncodeUtils;
import com.zbxsoft.core.utils.ExceptionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public abstract class DigestUtils {
	private static final String SHA1 = "SHA-1";
	private static final String MD5 = "MD5";

	public static String sha1Hex(String input) {
		byte[] digestResult = digest(input, "SHA-1");
		return EncodeUtils.encodeHex(digestResult);
	}

	public static String sha1Base64(String input) {
		byte[] digestResult = digest(input, "SHA-1");
		return EncodeUtils.encodeBase64(digestResult);
	}

	public static String sha1Base64UrlSafe(String input) {
		byte[] digestResult = digest(input, "SHA-1");
		return EncodeUtils.encodeUrlSafeBase64(digestResult);
	}

	private static byte[] digest(String input, String algorithm) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			return messageDigest.digest(input.getBytes());
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String md5Hex(InputStream input) throws IOException {
		return digest(input, "MD5");
	}

	public static String sha1Hex(InputStream input) throws IOException {
		return digest(input, "SHA-1");
	}

	private static String digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return EncodeUtils.encodeHex(messageDigest.digest());
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}
}
