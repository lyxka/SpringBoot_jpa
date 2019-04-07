package org.fh.shop.admin.mays.util;

import redis.clients.jedis.Jedis;

/**
 * 类名: JedisUtil
 * 描述：
 *
 * @author MYS
 * @create 2019-03-27 22:34
 */

public class JedisUtil {
    /**
     * redis中取值
     */
    public static String get(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
                jedis = null;
            }
        }
        return result;
    }

    /**
     * redis中放值 无时间限制
     */
    public static void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
                jedis = null;
            }
        }
    }

}

