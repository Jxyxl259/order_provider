package com.yaic.fa.redis.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yaic.fa.redis.callback.RedisCallback;
import com.yaic.fa.redis.utils.RedisPoolManager;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Redis操作-取号
 */
public class RedisTemplateTakeNo {
	private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateTakeNo.class);
	
    abstract class BaseTemplate {

    }

    private RedisPoolManager redisPoolManager;

    public RedisTemplateTakeNo(ShardedJedisPool shardedJedisPool) {
        this.redisPoolManager = new RedisPoolManager(shardedJedisPool);
    }

    /**
     * 描述：
     * <pre>
     *  获取自增序号
     * </pre>
     * @param k key 键值
     * @return 从1开始 
     */
    public long getIncrBy(final String k) {
        return (Long) execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(ShardedJedis shardedJedis) throws Exception {
                return shardedJedis.incrBy(k, 1);
            }
        });
    }

    // 执行方法
    @SuppressWarnings("unchecked")
    public <T> T execute(RedisCallback<?> callback) {
        boolean recovery = false;
        ShardedJedis dj = null;
        try {
            dj = redisPoolManager.getReids();
            return (T) callback.doInRedis(dj);
        } catch (Exception e) {
            recovery = true;
            LOG.error("redis execute error", e);
        } finally {
            redisPoolManager.recovery(dj, recovery);
            // dj.close();
        }
        return null;
    }

}
