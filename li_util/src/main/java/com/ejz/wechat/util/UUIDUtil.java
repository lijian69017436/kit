package com.ejz.wechat.util;

import java.util.UUID;

/**
 * 唯一标识编号生成工具类（采用UUID方式）
 * @Description 标准的UUID格式为：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxx (8-4-4-4-12)，其中每个 x 是 0-9 或 a-f 范围内的一个十六进制的数字。
 * @date  2011-12-13
 * @author hexin
 */
public class UUIDUtil {
	/**
	 * 获取标准的UUID序列
	 * @return 返回字符串格式为：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxx (8-4-4-4-12)
	 * 每个 x 是 0-9 或 a-f 范围内的一个十六进制的数字
	 */
	public static final String getUUID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		return str;
	}
	/**
	 * 获取标准的UUID序列
	 * @param replaceStr 指定序列中“-”字符被替换的值，默认/null 时 替换成空格
	 * @param len 指定返回字符串的长度，最大长度36
	 * @return 返回满足条件的字符串
	 */
	public static String getUUID(String replaceStr,int len){
		String str=UUIDUtil.getUUID();
		String retStr="";
		if (replaceStr!=null&&!"".equals(replaceStr.trim())) {
			retStr = str.replaceAll("-", replaceStr);
		}else{
			retStr = str.replaceAll("-", "");
		}
		return retStr.substring(0,len);
	}
}
