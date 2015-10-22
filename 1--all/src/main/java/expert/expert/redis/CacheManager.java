package expert.expert.redis;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存客户端工厂
 *  
 */
public class CacheManager {

	private static CacheClient client;

	/**
	 * 初始化缓存客户端
	 * @param servers ip地址 和端口号
	 * @param app    应用名称
	 * @param password  redis 密码  若无密码 则不写
	 */
	public static void setup(String servers, String app, String password) {
		client = new RedisCacheClient(servers, app, password);
	}

	/**
	 * 清理缓存客户端
	 */
	public static void cleanup() {
		client.cleanup();
	}

	/**
	 * 获取客户端实例
	 * 
	 * @return
	 */
	public static CacheClient getClient() {
		return client;
	}

	/* 获取指定配置的CacheClient */
	public static CacheClient getClient(String servers, String app,
			String password) {
		if (!serverMap.containsKey(servers)) {
			serverMap
					.put(servers, new RedisCacheClient(servers, app, password));
		}
		return serverMap.get(servers);
	}

	private static Map<String, RedisCacheClient> serverMap = new HashMap<String, RedisCacheClient>();
}
