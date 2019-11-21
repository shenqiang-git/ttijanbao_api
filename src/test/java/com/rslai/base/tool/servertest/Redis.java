package com.rslai.base.tool.servertest;
import redis.clients.jedis.Jedis;
import java.util.Set;

public class Redis {
    private static Jedis jedis = null;
    private static Redis instance = new Redis();

    public static Redis getInstance() {
        return instance;
    }

    public Redis() {
        if (instance == null) {
            Jedis jedis = new Jedis("172.30.9.211", 6379); // 连接 Redis 服务器
            jedis.auth("RKJp9qeX");
            this.jedis = jedis;
        }
    }

    /**
     * 根据库id清除某个库中的所有数据
     *
     * @param db_id 数据库id
     * @return
     */
    public boolean flushAll(int db_id) {
        jedis.select(db_id); // 选择库
        jedis.flushAll(); // 清除库
        return true;
    }

    /**
     * 根据正则表达式批量删除keys
     *
     * @param db_id   数据库id
     * @param pattern 正则表达式
     * @return
     */
    public boolean delByPattern(int db_id, String pattern) {
        jedis.select(db_id); // 选择库

        Set<String> keys = jedis.keys(pattern);
        if (keys != null && !keys.isEmpty()) {
            String keyArr[] = new String[keys.size()];
            jedis.del(keys.toArray(keyArr));
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ret = Redis.getInstance().flushAll(1);
        System.out.println(ret);

    }
}

