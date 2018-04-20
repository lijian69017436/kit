package com.zbxsoft.core.utils.security;

import com.zbxsoft.core.utils.EncodeUtils;
import com.zbxsoft.core.utils.ExceptionUtils;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class CryptoUtils {
	private static final String DES = "DES";
	private static final String AES = "AES";
	private static final String HMACSHA1 = "HmacSHA1";
	private static final int DEFAULT_HMACSHA1_KEYSIZE = 160;
	private static final int DEFAULT_AES_KEYSIZE = 128;

	public static byte[] hmacSha1(String input, byte[] keyBytes) {
		try {
			SecretKey secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(secretKey);
			return mac.doFinal(input.getBytes());
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String hmacSha1ToHex(String input, byte[] keyBytes) {
		byte[] macResult = hmacSha1(input, keyBytes);
		return EncodeUtils.encodeHex(macResult);
	}

	public static String hmacSha1ToBase64(String input, byte[] keyBytes) {
		byte[] macResult = hmacSha1(input, keyBytes);
		return EncodeUtils.encodeBase64(macResult);
	}

	public static String hmacSha1ToBase64UrlSafe(String input, byte[] keyBytes) {
		byte[] macResult = hmacSha1(input, keyBytes);
		return EncodeUtils.encodeUrlSafeBase64(macResult);
	}

	public static boolean isHexMacValid(String hexMac, String input, byte[] keyBytes) {
		byte[] expected = EncodeUtils.decodeHex(hexMac);
		byte[] actual = hmacSha1(input, keyBytes);

		return Arrays.equals(expected, actual);
	}

	public static boolean isBase64MacValid(String base64Mac, String input, byte[] keyBytes) {
		byte[] expected = EncodeUtils.decodeBase64(base64Mac);
		byte[] actual = hmacSha1(input, keyBytes);

		return Arrays.equals(expected, actual);
	}

	public static byte[] generateMacSha1Key() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
			keyGenerator.init(160);
			SecretKey secretKey = keyGenerator.generateKey();
			return secretKey.getEncoded();
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String generateMacSha1HexKey() {
		return EncodeUtils.encodeHex(generateMacSha1Key());
	}

	public static String desEncryptToHex(String input, byte[] keyBytes) {
		byte[] encryptResult = des(input.getBytes(), keyBytes, 1);
		return EncodeUtils.encodeHex(encryptResult);
	}

	public static String desEncryptToBase64(String input, byte[] keyBytes) {
		byte[] encryptResult = des(input.getBytes(), keyBytes, 1);
		return EncodeUtils.encodeBase64(encryptResult);
	}

	public static String desDecryptFromHex(String input, byte[] keyBytes) {
		byte[] decryptResult = des(EncodeUtils.decodeHex(input), keyBytes, 2);
		return new String(decryptResult);
	}

	public static String desDecryptFromBase64(String input, byte[] keyBytes) {
		byte[] decryptResult = des(EncodeUtils.decodeBase64(input), keyBytes, 2);
		return new String(decryptResult);
	}

	private static byte[] des(byte[] inputBytes, byte[] keyBytes, int mode) {
		try {
			DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(mode, secretKey);
			return cipher.doFinal(inputBytes);
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static byte[] generateDesKey() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			SecretKey secretKey = keyGenerator.generateKey();
			return secretKey.getEncoded();
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String generateDesHexKey() {
		return EncodeUtils.encodeHex(generateDesKey());
	}

	public static String aesEncryptToHex(String input, byte[] keyBytes) {
		byte[] encryptResult = aes(input.getBytes(), keyBytes, 1);
		return EncodeUtils.encodeHex(encryptResult);
	}

	public static String aesEncryptToBase64(String input, byte[] keyBytes) {
		byte[] encryptResult = aes(input.getBytes(), keyBytes, 1);
		return EncodeUtils.encodeBase64(encryptResult);
	}

	public static String aesDecryptFromHex(String input, byte[] keyBytes) {
		byte[] decryptResult = aes(EncodeUtils.decodeHex(input), keyBytes, 2);
		return new String(decryptResult);
	}

	public static String aesDecryptFromBase64(String input, byte[] keyBytes) {
		byte[] decryptResult = aes(EncodeUtils.decodeBase64(input), keyBytes, 2);
		return new String(decryptResult);
	}

	private static byte[] aes(byte[] inputBytes, byte[] keyBytes, int mode) {
		try {
			SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(mode, secretKey);
			return cipher.doFinal(inputBytes);
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static byte[] generateAesKey() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			return secretKey.getEncoded();
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String generateAesHexKey() {
		return EncodeUtils.encodeHex(generateAesKey());
	}
}
