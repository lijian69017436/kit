package com.zbxsoft.core.mapper;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * json 对象匹配成 java对象
 * java 对象转换成json 数据
 * @author Administrator
 *
 */
public class JsonMapper {
	private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
	private ObjectMapper mapper;

	public JsonMapper(JsonSerialize.Inclusion inclusion) {
		this.mapper = new ObjectMapper();

		this.mapper.getSerializationConfig().setSerializationInclusion(inclusion);

		this.mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		this.mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	}

	public static JsonMapper buildNormalMapper() {
		return new JsonMapper(JsonSerialize.Inclusion.ALWAYS);
	}

	public static JsonMapper buildNonNullMapper() {
		return new JsonMapper(JsonSerialize.Inclusion.NON_NULL);
	}

	public static JsonMapper buildNonDefaultMapper() {
		return new JsonMapper(JsonSerialize.Inclusion.NON_DEFAULT);
	}

	/**
	 * json 串 转换成 java 对象
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return this.mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
		}
		return null;
	}

	/**
	 * 转换 json数据 为 复杂 类型
	 * @param jsonString
	 * @param javaType 复杂类型 例如 List<user> Map<String,User> 等
	 * @return
	 */
	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return this.mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
		}
		return null;
	}

	/**
	 * 得到  javaType  
	 * 转换复杂类型  为javaType 类型  
	 * @param parametrized 例如 List.class Map.class HashMap.class
	 * @param parameterClasses 例如 User.class 参数可以是多个
	 * @return 
	 */
	public JavaType constructParametricType(Class<?> parametrized, Class<?>[] parameterClasses) {
		return this.mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
	}

	/**
	 * java 对象 转换胃 json 格式字符串
	 * @param object
	 * @return
	 */
	public String toJson(Object object) {
		try {
			return this.mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
		}
		return null;
	}

	/**
	 *   
     * 当JSON里只含有Bean的部分屬性时，更新一個已存在Bean，只覆盖該部分的屬性. 
	 * @param object
	 * @param jsonString
	 * @return
	 */
	public <T> T update(T object, String jsonString) {
		try {
			return this.mapper.updatingReader(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
			logger.warn("parse json string" + jsonString + " to object:" + object + " error.", e);
		} catch (IOException e) {
			logger.warn("parse json string" + jsonString + " to object:" + object + " error.", e);
		}
		return null;
	}

	/**
	 * 
	 * @param functionName
	 * @param object
	 * @return
	 */
	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}

	public void setEnumUseToString(boolean value) {
		this.mapper.getSerializationConfig().set(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, value);
		this.mapper.getDeserializationConfig().set(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, value);
	}

	public ObjectMapper getMapper() {
		return this.mapper;
	}
}
