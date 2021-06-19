package com.fan;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class TestMain {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.16.61.109", 6379);
        jedis.auth("123");
//        jedis.set("key1","少年郎1");
        String name = jedis.get("key1");
        System.out.println(name);
//        jedis.set("jedis1","yaya");
//        jedis.expire("jedis1",100L);
//        jedis.setnx("jedis1","hehe");
        try {
//            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jedis.ttl("jedis1") + ":" + jedis.get("jedis1"));
//        jedis.lpush("list1","sa1","sa2","sa3","as","bs");
        System.out.println(jedis.keys("*") + ":" + jedis.lrange("list1", 0, -1));
        SortingParams params = new SortingParams();
        System.out.println(jedis.sort("list1", params.alpha()));

        jedis.close();
    }
}
