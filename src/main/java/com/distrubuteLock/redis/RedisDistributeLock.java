package com.distrubuteLock.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Package:com.distrubuteLock.redis
 * *Author:ray
 * *version:...
 * *Created in 2019/8/25  12:39
 **/
public class RedisDistributeLock extends AbstractDistributeLock {

	private final Logger logger = LoggerFactory.getLogger(RedisDistributeLock.class);

	private RedisTemplate<Object, Object> redisTemplate;

	private ThreadLocal<String> lockFlag = new ThreadLocal<>();

	public static final String UNLOCK_LUA;

	static {
		StringBuilder sb = new StringBuilder();
		sb.append("if redis.call(\"get\"KEYS[1]==ARGV[1])");
		sb.append("then");
		sb.append("  return redis.call(\"del\".KEYS[1])");
		sb.append("else");
		sb.append("  return 0");
		sb.append("end");
		UNLOCK_LUA = sb.toString();
	}

	public RedisDistributeLock(RedisTemplate<Object, Object> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}


	@Override
	public boolean lock(String key, long expire, long sleepMillis) {
		return false;
	}

	@Override
	public boolean lock(String key, long expire, int retryTimes, long sleepMillis) {
		boolean result=setRedis(key,expire );
		while((!result)&&retryTimes-->0){
			logger.info("locking failed,retrying..."+retryTimes );
			try {
				Thread.sleep(sleepMillis);
			} catch (InterruptedException e) {
				return false;
			}
			result=setRedis(key,expire );
			return result;
		}

		return false;
	}

	@Override
	public boolean releaseLock(String key) {
		try {
			//释放锁的时候,有可能因为持锁之后的方法执行时间大于锁的有效期
			//此时可能会有另外一个线程持有锁,所以不能直接删除key
			List<String> keys=new ArrayList<>();
			keys.add(key);
			List<String> args=new ArrayList<>();
			args.add(lockFlag.get());
			//使用lua脚本删除redis中匹配value的key,可以避免由于方法的执行时间过长而redis锁自动过期的时候误删除其他线程的锁
			//spring自带的执行脚本中,集群模式直接抛出不支持执行脚本的异常,所以只能拿到源redis的connection来执行脚本
			Long result=redisTemplate.execute(new RedisCallback<Long>() {
				@Override
				public Long doInRedis(RedisConnection connection) throws DataAccessException {
					Object nativeConnection = connection.getNativeConnection();
					//集群模式和单机模式执行脚本的方法虽然一样,但是由于没有共同的接口,所以只能进行分开实现
					//集群模式
					if (nativeConnection instanceof JedisCluster){
						return (Long)((JedisCluster) nativeConnection).eval(UNLOCK_LUA,keys,args );
					}
					//单机模式
					else if (nativeConnection instanceof Jedis){
						return (Long)((Jedis) nativeConnection).eval(UNLOCK_LUA,keys,args );
					}
					return 0L;
				}
			});
			return result!=null&&result>0;
		} catch (Exception e) {
			logger.error("release lock occured an exception",e );
		}
		return false;
	}

	private boolean setRedis(String key, long expire) {

		try {
			String result = redisTemplate.execute(new RedisCallback<String>() {
						@Override
						public String doInRedis(RedisConnection connection) throws DataAccessException {
							JedisCommands commands = (JedisCommands) connection.getNativeConnection();
							String uuid = UUID.randomUUID().toString();
							lockFlag.set(uuid);
							return commands.set(key, uuid, "NX", "PX", expire);
						}
					});
			return !StringUtils.isEmpty(result);
		} catch (Exception e) {
			logger.error("setRedis occured an exception",e );
		}
		return false;
	}



}
