package com.fan;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        JedisPool pool = new JedisPool(config, "10.16.61.109", 6379);
        Jedis jedis = pool.getResource();
        jedis.auth("123");
        jedis.set("key6", "45");
        jedis.decr("key6");
        System.out.println(jedis.get("key6"));
        jedis.close();

    }
}
