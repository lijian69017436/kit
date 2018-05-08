package com.ejz.wechat.main;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 本地缓存 Map
 */
public class WechatCacheMap  {

	private Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

	public Object get(String mpId) {
		return cache.get(mpId);
	}

	public void set(String mpId, Object object, long expires) {
		cache.put(mpId, object);
	}

	public void remove(String mpId) {
		cache.remove(mpId);
	}
}
