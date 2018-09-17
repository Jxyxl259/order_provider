package com.yaic.fa.redis.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yaic.fa.redis.callback.RedisCallback;
import com.yaic.fa.redis.callback.RedisNoResultCall;
import com.yaic.fa.redis.utils.RedisPoolManager;
import com.yaic.fa.redis.utils.SerializerUtils;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;

/**
 * Redis操作API
 * <p>User: lujicong
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public class RedisTemplateCheckProp {
	private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateCheckProp.class);
	
	abstract class BaseTemplate{
		
	}
	
	private RedisPoolManager redisPoolManager;
	
	
	public RedisTemplateCheckProp(ShardedJedisPool shardedJedisPool){
		this.redisPoolManager = new RedisPoolManager(shardedJedisPool);
	}

	

	/**
	 * 描述：
	 * <pre>
	 * 	放入redis缓存
	 * </pre>
	 * @param k
	 * @param v
	 */
	public void set(String k, Object v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[] value = SerializerUtils.rawValue(v);
		execute( new RedisNoResultCall(){
			@Override
			public void action(ShardedJedis shardedJedis) {
				shardedJedis.set(key, value);
			}} );
	}
	
	/**
     * 描述：
     * <pre>
     *  放入缓存有效时间
     * </pre>
     * @param k 键值
     * @param seconds 有效时间,单位秒(s) 
     */
    public void expire(String k, final int seconds){
        final byte[] key = SerializerUtils.rawKey(k);
        execute(new RedisNoResultCall(){
            @Override
            public void action(ShardedJedis shardedJedis) {
                shardedJedis.expire(key, seconds);
            }
        });
    }
	
    /**
     * Redis Zadd 命令
     * @param key 证件类型_证件号码_riskcode
     * @param score 终保时间戳
     * @param member 保单号
     */
    public Long zadd(final String key, final double score, final String member) {
        return (Long) execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(ShardedJedis shardedJedis) {
                return shardedJedis.zadd(key, score, member);
            }
        });
    }
    
    /**
     * Redis Zcount 命令 计算有序集合中指定分数区间的成员数量
     * @param key 证件类型_证件号码_riskcode
     * @param min 分数值在 min 和 max 之间的成员的数量
     * @param max 
     */
    public Long zcount(final String key, final double min, final double max) {
        return (Long) execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(ShardedJedis shardedJedis) {
                return shardedJedis.zcount(key, min, max);
            }
        });
    }
	
    /**
     * Redis zremrangeByScore 命令 删除的有序集合保存在key的最小值和最大值(含)之间的分数的所有元素
     * @param key 证件类型_证件号码_riskcode
     * @param start
     * @param end
     */
    public Long zremrangeByScore(final String key, final double start, final double end) {
        return (Long) execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(ShardedJedis shardedJedis) {
                return shardedJedis.zremrangeByScore(key, start, end);
            }
        });
    }

    /**
     * Redis zremrangeByScore 命令 删除的有序集合保存在key的最小值和最大值(含)之间的分数的所有元素
     * @param key 证件类型_证件号码_riskcode
     * @param start
     * @param end
     */
    public Long zremrangeByScore(final String key, final String start, final String end) {
        return (Long) execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(ShardedJedis shardedJedis) {
                return shardedJedis.zremrangeByScore(key, start, end);
            }
        });
    }
    
    /**
     * Redis Zcount 命令 计算有序集合中指定分数区间的成员数量
     * @param key 证件类型_证件号码_riskcode
     * @param min 分数值在 min 和 max 之间的成员的数量
     * @param max 
     */
    @SuppressWarnings("unchecked")
	public Set<String> zrangeByScore(final String key, final String min, final String max) {
        return (Set<String>) execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(ShardedJedis shardedJedis) {
                return shardedJedis.zrangeByScore(key, min, max);
            }
        });
    }
    
	/**
	 * 描述：
	 * <pre>
	 * 	放入缓存
	 * </pre>
	 * @param k 键值
	 * @param v 缓存值
	 * @param seconds 有效时间,单位秒(s) 
	 */
	public void set(String k, Object v, final int seconds){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[] value = SerializerUtils.rawValue(v);
		execute(new RedisNoResultCall(){
			@Override
			public void action(ShardedJedis shardedJedis) {
				shardedJedis.setex(key, seconds, value);
			}
		});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	获取某个缓存的存活时间
	 * </pre>
	 * @param k key 键值
	 * @return 有效时间，单位秒(s)[-2  键不存在][-1 没有设置键的生存时间]
	 */
	public long getLifeTime(String k){
		final byte[] key = SerializerUtils.rawKey(k);
		return (Long) execute(new RedisCallback<Long>() {
			@Override
            public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
				return shardedJedis.ttl(key);
			}
		});
		
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 		获取值
	 * </pre>
	 * @param k
	 * @return
	 */
	public Object get(final String k){
		final byte[] key = SerializerUtils.rawKey(k);
		byte[] value = (byte[]) execute(new RedisCallback<byte[]>(){
			@Override
            public byte[] doInRedis(ShardedJedis shardedJedis) throws Exception {
				JedisShardInfo info = shardedJedis.getShardInfo(key);
				LOG.info("Info for key '{}': host='{}', name='{}', port='{}'", k, info.getHost(), info.getName(), info.getPort());
				return shardedJedis.get(key);
			}
		});
		return SerializerUtils.getRedisserializer().deserialize(value);
	}
	
	
	
	/**
	 * 描述：
	 * <pre>
	 * 	像现有的元素追加元素
	 * </pre>
	 * @param k 键值
	 * @param v 新追加的值
	 */
	public void append(String k, Object v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[] value = SerializerUtils.rawValue(v);
		execute(new RedisNoResultCall(){
			@Override
			public void action(ShardedJedis shardedJedis) {
				shardedJedis.append(key, value);
			}});
	}
	
	/**
     * 向现有的元素追加值
     * @param key 键值
     * @param value 新追加的值
     * @return 返回新字符串长度
     */
    public Object appendExt(String key, Object value) {
        final byte[] keyByte = SerializerUtils.rawKey(key);
        final byte[] valueByte = SerializerUtils.rawValue(value);
        Long result = execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
                return shardedJedis.append(keyByte, valueByte);
            }
        });
        return Integer.parseInt(String.valueOf(result));
    }
	
	/**
	 * 描述：
	 * <pre>
	 * 	List型数据存储，数据向前累加
	 * 默认leftPush
	 * </pre>
	 * @param k
	 * @param v
	 * @return
	 */
	public Long lPush(String k, Object ... v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[][] value = SerializerUtils.rawValues(v);
		return (Long) execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
				return shardedJedis.lpush(key, value);
			}
		});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 		List数据存储，
	 * 		rightPush
	 * </pre>
	 * @param k
	 * @param v
	 * @return
	 */
	public Long rPush(String k, Object ... v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[][] value = SerializerUtils.rawValues(v);
		return execute(new RedisCallback<Long>(){
			@Override
			public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
				return shardedJedis.rpush(key, value);
			}});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	排序
	 * </pre>
	 * @param k
	 * @param sortingParameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> sort(String k, final SortingParams sortingParameters){
		final byte[] key = SerializerUtils.rawKey(k);
		List<byte[]> b =  execute(new RedisCallback<List<byte[]>>() {
			@Override
			public List<byte[]> doInRedis(ShardedJedis shardedJedis) throws Exception {
				if(sortingParameters == null){
					return shardedJedis.sort(key);
				}
				return shardedJedis.sort(key, sortingParameters);
			}
		});
		return SerializerUtils.deserializeValues(b, List.class, SerializerUtils.getRedisserializer());
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * Set集合新增
	 * </pre>
	 * @param k
	 * @param v
	 * @return
	 */
	public Long sadd(String k, Object ... v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[][] value = SerializerUtils.rawValues(v);
		return execute(new RedisCallback<Long>(){
			@Override
			public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
				return shardedJedis.sadd(key, value);
			}});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 
	 * Set集合中，删除某些元素
	 * </pre>
	 * @param k
	 * @param v
	 * @return
	 */
	public  Long sdelete(String k, Object ... v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[][] value = SerializerUtils.rawValues(v);
		return execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
				return shardedJedis.srem(key, value);
			}
		});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	通过key来获取对应的set集合
	 * </pre>
	 * @param k
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Set<T> sgetAll(String k){
		final byte[] key = SerializerUtils.rawKey(k);
		Set<byte[]> rawValues = execute(new RedisCallback<Set<byte[]>>() {
			@Override
			public Set<byte[]> doInRedis(ShardedJedis shardedJedis)
					throws Exception {
				return shardedJedis.smembers(key);
			}
		});
		return SerializerUtils.deserializeValues(rawValues, Set.class, SerializerUtils.getRedisserializer());
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 		Set集合 
	 * 		判断指定元素在该集合中是否存在
	 * </pre>
	 * @param k
	 * @param v
	 * @return
	 */
	public boolean sisExist(String k, Object v){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[] value = SerializerUtils.rawValue(v);
		return execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(ShardedJedis shardedJedis)
					throws Exception {
				return shardedJedis.sismember(key, value);
			}
		});
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 		HashMap集合存储
	 * </pre>
	 * @param k
	 * @param m
	 */
	public void hset(String k, Map<?, ?> m ){
		if (m == null || m.isEmpty()) {
			return;
		}
		final byte[] key = SerializerUtils.rawKey(k);
		final Map<byte[], byte[]> hashes = new LinkedHashMap<byte[], byte[]>(m.size());
		for (Map.Entry<?, ? > entry : m.entrySet()) {
			hashes.put(SerializerUtils.rawHashKey(entry.getKey()), SerializerUtils.rawHashValue(entry.getValue()));
		}
		execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(ShardedJedis shardedJedis)
					throws Exception {
				return shardedJedis.hmset(key, hashes);
			}
		});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 		HashMap删除对应的 KEY数据
	 * </pre>
	 * @param k
	 * @param hashK
	 */
	public void hdelete(String k, Object ... hashK){
		final byte[] key = SerializerUtils.rawKey(k);
		final byte[][] hashKey = SerializerUtils.rawHashKeys(hashK);
		execute(new RedisCallback<Object>() {
			@Override
            public Object doInRedis(ShardedJedis shardedJedis) {
				shardedJedis.hdel(key, hashKey);
				return null;
			}
		});
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 	在Map中查询该值是否存在
	 * </pre>
	 * @param k
	 * @param hashK
	 * @return
	 */
	public boolean hisExists(String k, Object hashK){
		final byte[] rawKey = SerializerUtils.rawKey(k);
		final byte[] rawHashKey = SerializerUtils.rawHashKey(hashK);
		return execute(new RedisCallback<Boolean>() {

			@Override
            public Boolean doInRedis(ShardedJedis shardedJedis) {
				return shardedJedis.hexists(rawKey, rawHashKey);
			}
		});
	}
	
	
	
	/**
	 * 描述：
	 * <pre>
	 * 		获取指定的list集合
	 * </pre>
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> lrange(String k, final long start, final long end){
		final byte[] key = SerializerUtils.rawKey(k);
		return (List<Object>) execute(new RedisCallback<List<Object>>() {
			@Override
			public List<Object> doInRedis(ShardedJedis shardedJedis) throws Exception {
				List<byte[]> rawValues = shardedJedis.lrange(key, start, end);
				return SerializerUtils.deserializeValues(rawValues, List.class, SerializerUtils.getRedisserializer());
			}
		});
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	删除缓存
	 * </pre>
	 * @param k
	 */
	public void delete(String k){
		final byte[] key = SerializerUtils.rawKey(k);
		execute(new RedisNoResultCall(){
			@Override
			public void action(ShardedJedis shardedJedis) {
				shardedJedis.del(key);
			}
		});
	}
	
	
	//执行方法
	@SuppressWarnings("unchecked")
	public <T> T execute(RedisCallback<?> callback){
		boolean recovery = false;
		ShardedJedis dj = null;
		try {
			dj = redisPoolManager.getReids();
			return (T) callback.doInRedis(dj);
		} catch (Exception e) {
			recovery= true;
			LOG.error("redis execute error", e);
		}finally {
			redisPoolManager.recovery(dj, recovery);
			//dj.close();
		}
		return null;
	}

	
}
