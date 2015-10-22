package expert.expert.redis;

/**
 * 缓存客户端的基类
 *  
 */
public abstract class CacheClientBase {

	private String prefix;
	public CacheClientBase(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * 提供缓存的解析
	 * 
	 * @param key
	 * @return
	 */
	protected String resolveKey(String key) {
		return prefix + ":" + key;
	}
	protected byte[] resolveKey(byte[] key) {
		return key;
	}
}
