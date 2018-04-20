package com.ejz.wechat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 正则表达式工具类
 * </p>
 */
public class MatcherUtil {

	/**
	 * 验证字符串是否为数字或字母
	 * <p>
	 * 
	 * @param str
	 *            匹配的字符串
	 * @return boolean
	 */
	public static boolean isLetterAndNum(String str) {
		return match("[A-Za-z0-9]*", str);
	}

	/**
	 * 验证字符串是否为数字
	 * <p>
	 * 
	 * @param str
	 *            匹配的字符串
	 * @return boolean
	 */
	public static boolean isNumber(String str) {
		return match("[0-9]*", str);
	}

	/**
	 * 验证邮箱格式是否正确
	 * <p>
	 * 
	 * @param str
	 *            匹配的字符串
	 * @return boolean
	 */
	public static boolean isEmail(String str) {
		return match(
				"^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",
				str);
	}

	/**
	 * 验证字符串是否为手机号码
	 * <p>
	 * 
	 * @param str
	 *            匹配的字符串
	 * @return boolean
	 */
	public static boolean isMobile(String str) {
		return match("^(1[0-9])\\d{9}$", str);
	}

	/**
	 * 判断是否为合法IP
	 * 
	 * @param ip
	 *            ip地址
	 * @return
	 */
	public static boolean isIp(String ip) {
		return match("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", ip);
	}

	/**
	 * 正则表达式匹配
	 * 
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
