package com.distrubuteLock.redis;

/**
 * Package:com.distrubuteLock.redis
 * *Author:ray
 * *version:...
 * *discription: 分布式锁的父级接口
 * *Created in 2019/8/24  23:37
 **/

public interface DistributeLock {


	public static final long TIMEOUT_MILLIS=30000;//超时毫秒数

	public static final int RETRY_TIMES=Integer.MAX_VALUE;

	public static final long SLEEP_MILLIS=500;

	public boolean lock(String key);

	public boolean lock(String key,int retryTimes);

	public boolean lock(String key,int retryTimes,long sleepMillis);

	public boolean lock(String key,long expire);

	public boolean lock(String key,long expire,long sleepMillis);

	public boolean lock(String key,long expire,int retryTimes);

	public boolean lock (String key,long expire,int retryTimes,long sleepMillis);

	public boolean releaseLock(String key);


}
