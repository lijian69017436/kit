package expert.expert.redis;

import java.util.ArrayList;
import java.util.List; 
import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.util.Hashing;

/**
 * 实现使用Redis作为缓存的客户端封装
 * 
 */
public class RedisCacheClient extends CacheClientBase implements CacheClient {

	// 默认超时时间
	private static final int DEFAULT_TIMEOUT = 4000;

	// 默认最大活动连接数
	private static final int MAX_ACTIVE = 20;

	// 默认最大空闲连接数
	private static final int MAX_IDLE = 10;

	// 默认最大等待
	private static final int MAX_WAIT = 100 * 1000;

	private ShardedJedisPool pool;

	public RedisCacheClient(String servers, String component, String password) {
		super(component);
		String[] hosts = servers.trim().split("\\|");

		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();

		for (String host : hosts) {
			String[] ss = host.split(":");
			JedisShardInfo shard = new JedisShardInfo(ss[0],
					Integer.parseInt(ss[1]), DEFAULT_TIMEOUT, 1);
			if (!password.equals(""))
				shard.setPassword(password);
			shards.add(shard);
		}

		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(MAX_ACTIVE);
		config.setMaxIdle(MAX_IDLE);;
		config.setMaxWaitMillis(MAX_WAIT);
		config.setTestWhileIdle(true);
		config.setTimeBetweenEvictionRunsMillis(10 * 1000);

		pool = new ShardedJedisPool(config, shards, Hashing.MURMUR_HASH);
	}

	@Override
	public void cleanup() {
		pool.destroy();
	}

	@Override
	public void set(String key, String value) {
		ShardedJedis redis = pool.getResource();
		try {
			redis.set(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
	}

	@Override
	public void set(byte[] key, byte[] value) {
		ShardedJedis redis = pool.getResource();
		try {
			redis.set(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
	}

	@Override
	public String setex(byte[] key, int seconds, byte[] value) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.setex(resolveKey(key), seconds, value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long setnx(byte[] key, byte[] value) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.setnx(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public byte[] get(byte[] key) {
		ShardedJedis redis = pool.getResource();
		byte[] result = null;
		try {
			result = redis.get(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String get(String key) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.get(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long incr(String key) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.incr(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long decr(String key) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.decr(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public void del(String... keys) {
		ShardedJedis redis = pool.getResource();
		try {
			for (int i = 0; i < keys.length; i++) {
				redis.getShard(resolveKey(keys[i])).del(resolveKey(keys[i]));
			}
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
	}

	@Override
	public Long expire(String key, int seconds) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.expire(resolveKey(key), seconds);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long lpush(String key, String value) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.lpush(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public List<String> lrange(String key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		List<String> result = null;
		try {
			result = redis.lrange(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Boolean exists(byte[] key) {
		ShardedJedis redis = pool.getResource();
		Boolean result = false;
		try {
			result = redis.exists(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Boolean hexists(byte[] key, byte[] field) {
		ShardedJedis redis = pool.getResource();
		Boolean result = false;
		try {
			result = redis.hexists(resolveKey(key), field);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Boolean exists(String key) {
		ShardedJedis redis = pool.getResource();
		Boolean result = false;
		try {
			result = redis.exists(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String hmset(String key, Map<String, String> hash) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.hmset(resolveKey(key), hash);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		ShardedJedis redis = pool.getResource();
		Map<String, String> result = null;
		try {
			result = redis.hgetAll(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String hget(String key, String field) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.hget(resolveKey(key), field);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long llen(String key) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.llen(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String lindex(String key, long index) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.lindex(resolveKey(key), index);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}
	/*
	 * @Override public List<String> brpop(int timeout, String... keys) {
	 * ShardedJedis redis = pool.getResource();
	 * 
	 * pool.returnResource(redis); for (int i = 0; i < keys.length; i++) {
	 * keys[i] = resolveKey(resolveKey(key)s[i]); } return redis.brpop(timeout,
	 * keys);
	 * 
	 * }
	 */

	@Override
	public Long lpush(byte[] key, byte[] value) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.lpush(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long rpush(byte[] key, byte[] value) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.rpush(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	/*
	 * @Override public List<byte[]> brpop(int timeout, byte[]... keys) {
	 * ShardedJedis redis = pool.getResource();
	 * 
	 * pool.returnResource(redis); for (int i = 0; i < keys.length; i++) {
	 * keys[i] = resolveKey(new String(resolveKey(key)s[i])).getBytes(); }
	 * return redis.brpop(timeout, keys);
	 * 
	 * }
	 */

	@Override
	public Map<byte[], byte[]> hgetAll(byte[] key) {
		ShardedJedis redis = pool.getResource();
		Map<byte[], byte[]> result = null;
		try {
			result = redis.hgetAll(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String hmset(byte[] key, Map<byte[], byte[]> hash) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.hmset(resolveKey(key), hash);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public List<byte[]> sort(String key, String patterns) {
		ShardedJedis redis = pool.getResource();
		List<byte[]> result = null;
		try {
			result = redis.sort(resolveKey(key).getBytes(),
					new SortingParams().get(patterns));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public List<byte[]> lrange(byte[] key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		List<byte[]> result = null;
		try {
			result = redis.lrange(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public long hincrBy(String key, String field, long value) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.hincrBy(resolveKey(key), field, value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public long hdel(String key, String field) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.hdel(resolveKey(key), field);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public long setnx(String key, String value) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.setnx(resolveKey(key), value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long hset(byte[] key, byte[] field, byte[] value) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.hset(resolveKey(key), field, value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long hdel(byte[] key, byte[] field) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.hdel(resolveKey(key), field);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public void zadd(String key, double score, String member) {
		ShardedJedis redis = pool.getResource();
		try {
			redis.zadd(resolveKey(key), score, member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
	}

	@Override
	public Long hset(String key, String field, String value) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.hset(resolveKey(key), field, value);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Set<byte[]> keys(byte[] pattern) {
		ShardedJedis redis = pool.getResource();
		Set<byte[]> result = null;
		try {
			result = redis.hkeys(pattern);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Set<String> keys(String pattern) {
		ShardedJedis redis = pool.getResource();
		Set<String> result = null;
		try {
			result = redis.hkeys(pattern);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public byte[] hget(byte[] key, byte[] field) {
		ShardedJedis redis = pool.getResource();
		byte[] result = null;
		try {

			result = redis.hget(resolveKey(key), field);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public List<String> hmget(String key, String... fields) {
		ShardedJedis redis = pool.getResource();
		List<String> result = null;
		try {
			result = redis.hmget(resolveKey(key), fields);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public List<byte[]> hmget(byte[] key, byte[]... fields) {
		ShardedJedis redis = pool.getResource();
		List<byte[]> result = null;
		try {
			result = redis.hmget(resolveKey(key), fields);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long zcard(String key) {
		ShardedJedis redis = pool.getResource();
		long score = -1L;
		try {
			score = redis.zcard(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return score;
	}

	@Override
	public Long zcard(byte[] key) {
		ShardedJedis redis = pool.getResource();
		long score = -1L;
		try {
			score = redis.zcard(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return score;
	}

	@Override
	public Set<String> zrangeByScore(String key, long min, long max) {
		ShardedJedis redis = pool.getResource();
		Set<String> set = null;
		try {
			set = redis.zrangeByScore(resolveKey(key), (double) min,
					(double) max);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public Set<byte[]> zrangeByScore(byte[] key, long min, long max) {
		ShardedJedis redis = pool.getResource();
		Set<byte[]> set = null;
		try {
			set = redis.zrangeByScore(resolveKey(key), (double) min,
					(double) max);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public Long zcount(String key, long min, long max) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.zcount(resolveKey(key), min, max);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long zcount(byte[] key, long min, long max) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.zcount(resolveKey(key), min, max);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Set<String> zrange(String key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		Set<String> set = null;
		try {
			set = redis.zrange(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public Set<byte[]> zrange(byte[] key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		Set<byte[]> set = null;
		try {
			set = redis.zrange(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public Set<Tuple> zrangeWithScores(String key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		Set<Tuple> set = null;
		try {
			set = redis.zrangeWithScores(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public Set<Tuple> zrangeWithScores(byte[] key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		Set<Tuple> set = null;
		try {
			set = redis.zrangeWithScores(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public long zrem(String key, String member) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.zrem(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public long zrem(byte[] key, byte[] member) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.zrem(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.zremrangeByScore(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long zremrangeByScore(byte[] key, double start, double end) {
		ShardedJedis redis = pool.getResource();
		long result = -1L;
		try {
			result = redis.zremrangeByScore(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@SuppressWarnings("deprecation")
  @Override
	public List<Object> pipelined(ShardedJedisPipeline shardedJedisPipeline) {
		ShardedJedis redis = pool.getResource();
		List<Object> result = null;
		try {
			result = redis.pipelined(shardedJedisPipeline);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long sadd(byte[] key, byte[] member) {
		ShardedJedis redis = pool.getResource();
		long result = 0l;
		try {
			result = redis.sadd(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long sadd(String key, String member) {
		ShardedJedis redis = pool.getResource();
		long result = 0l;
		try {
			result = redis.sadd(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long scard(byte[] key) {
		ShardedJedis redis = pool.getResource();
		long result = 0l;
		try {
			result = redis.scard(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long scard(String key) {
		ShardedJedis redis = pool.getResource();
		long result = 0l;
		try {
			result = redis.scard(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Boolean sismember(byte[] key, byte[] member) {
		ShardedJedis redis = pool.getResource();
		boolean result = false;
		try {
			result = redis.sismember(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Boolean sismember(String key, String member) {
		ShardedJedis redis = pool.getResource();
		boolean result = false;
		try {
			result = redis.sismember(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Set<byte[]> smembers(byte[] key) {
		ShardedJedis redis = pool.getResource();
		Set<byte[]> result = null;
		try {
			result = redis.smembers(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Set<String> smembers(String key) {
		ShardedJedis redis = pool.getResource();
		Set<String> result = null;
		try {
			result = redis.smembers(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public byte[] spop(byte[] key) {
		ShardedJedis redis = pool.getResource();
		byte[] result = null;
		try {
			result = redis.spop(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String spop(String key) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.spop(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public byte[] srandmember(byte[] key) {
		ShardedJedis redis = pool.getResource();
		byte[] result = null;
		try {
			result = redis.srandmember(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public String srandmember(String key) {
		ShardedJedis redis = pool.getResource();
		String result = null;
		try {
			result = redis.srandmember(resolveKey(key));
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long srem(byte[] key, byte[] member) {
		ShardedJedis redis = pool.getResource();
		Long result = 0l;
		try {
			result = redis.srem(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long srem(String key, String member) {
		ShardedJedis redis = pool.getResource();
		Long result = 0l;
		try {
			result = redis.srem(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long zrank(byte[] key, byte[] member) {
		ShardedJedis redis = pool.getResource();
		Long result = 0l;
		try {
			result = redis.zrank(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Long zrevrank(byte[] key, byte[] member) {
		ShardedJedis redis = pool.getResource();
		Long result = 0l;
		try {
			result = redis.zrevrank(resolveKey(key), member);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

	@Override
	public Set<Tuple> zrevRangeWithScores(String key, int start, int end) {
		ShardedJedis redis = pool.getResource();
		Set<Tuple> set = null;
		try {
			set = redis.zrevrangeWithScores(resolveKey(key), start, end);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return set;
	}

	@Override
	public Long rpush(String key, String... values) {
		ShardedJedis redis = pool.getResource();
		Long result = -1L;
		try {
			result = redis.rpush(resolveKey(key), values);
			pool.returnResource(redis);
		} catch (Exception e) {
			pool.returnBrokenResource(redis);
		}
		return result;
	}

}
