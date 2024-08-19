package com.hspedu.seckill.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 使用连接池的方式来获取Redis连接
 */
public class JedisPoolUtil {

    //volatile
    //1. 保证线程的可见性：当一个线程去修改一个共享变量时，另外一个线程可以读取这个修改的值
    //2. 保证顺序的一致性：禁止指令重排
    private static volatile JedisPool jedisPool = null;


    private JedisPoolUtil() {

    }

    // 保证每次调用返回的 JedisPool 是单例-这里使用了双重校验
    public static JedisPool getJedisPoolInstance() {

        if (null == jedisPool) {

            synchronized (JedisPoolUtil.class) {

                if (null == jedisPool) {

                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    // 对连接池进行配置
                    jedisPoolConfig.setMaxTotal(200);
                    jedisPoolConfig.setMaxIdle(32);
                    jedisPoolConfig.setMaxWaitMillis(60 * 1000);
                    jedisPoolConfig.setBlockWhenExhausted(true);
                    jedisPoolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(jedisPoolConfig, "192.168.150.102", 6379, 60 * 1000);
                }

            }

        }
        return jedisPool;
    }

    // 释放连接资源
    public static void release(Jedis jedis) {

        if (null != jedis) {
            jedis.close(); // 如果这个jedis是从连接池获取的，这里 jedis.close()，就是将jedis对象/连接，释放到连接池
        }

    }

}
