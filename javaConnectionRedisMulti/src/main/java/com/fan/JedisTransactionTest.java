package com.fan;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTransactionTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.16.61.109", 6379);
        jedis.auth("123");
        Transaction transaction = jedis.multi();
        transaction.incrBy("aq1", 111L);
        transaction.decrBy("aq2", 111L);
        System.out.println(transaction.get("aq1").toString());
//        transaction.discard();
        transaction.exec();

        System.out.println(jedis.get("aq1"));
        jedis.close();

    }
}
