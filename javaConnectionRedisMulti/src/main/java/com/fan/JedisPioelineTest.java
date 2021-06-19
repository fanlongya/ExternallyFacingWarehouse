package com.fan;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class JedisPioelineTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.16.61.109", 6379);
        jedis.auth("123");
        String key = "key2";
        jedis.setnx(key, "0");
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 10; i++) {
            pipeline.incr(key);
        }
        pipeline.sync();
        System.out.println(jedis.get(key));
        jedis.close();
    }
}
