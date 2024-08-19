package com.hspedu.seckill.redis;

import com.hspedu.seckill.util.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

public class SecKillRedis {

    /**
     * 编写一个测试方法-看看是否能够连通到指定的Redis
     */

    @Test
    public void testRedis() {

        Jedis jedis = new Jedis("192.168.150.102", 6379);
        //jedis.auth("foobared");
        System.out.println(jedis.ping());
        jedis.close();
    }

    /**
     * 秒杀过程/方法
     *
     * @param uid      用户id - 在后台生成
     * @param ticketNo 票的编号，比如北京-成都的 ticketNo 就是bj_cd
     * @return
     */

    public static boolean doSecKill(String uid, String ticketNo) {

        //- uid 和 ticketNo 进行非空校验
        if (uid == null || ticketNo == null) {
            return false;
        }
        //- 连接到Redis，得到Jedis对象
        //Jedis jedis = new Jedis("192.168.150.102", 6379);

        //- 通过连接池获取到jedis对象/连接
        JedisPool jedisPoolInstance = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = jedisPoolInstance.getResource();
        System.out.println("---使用的连接池技术---");

        //- 拼接票的库存key
        String stockKey = "sk:" + ticketNo + ":ticket";

        //- 拼接秒杀用户要存放到的set集合对应的key，这个set集合可以存放多个userId
        String userKey = "sk:" + ticketNo + ":user";

        //监控库存
        jedis.watch(stockKey);


        //- 获取到对应的票的库存，判断是否为null
        String stock = jedis.get(stockKey);
        if (stock == null) {
            System.out.println("秒杀还没有开始，请等待..");
            jedis.close(); // 如果jedis是从连接池获取的，则这里的close就是将jedis对象/连接释放到连接池
            return false;
        }

        //- 判断用户是否重复秒杀/复购
        if (jedis.sismember(userKey, uid)) {
            System.out.println("用户" + uid + "已经秒杀过该商品了");
            jedis.close();
            return false;
        }

        //- 判断火车票，是否还有剩余
        if (Integer.parseInt(stock) <= 0) {
            System.out.println("票已经卖完了，秒杀结束..");
            jedis.close();
            return false;
        }

        /*//- 可以购买
        //1. 将票的库存量-1
        jedis.decr(stockKey);
        //2. 将该用户加入到抢购成功对应的set集合中
        jedis.sadd(userKey, uid);*/

        //使用事务，完成秒杀
        Transaction multi = jedis.multi();

        //组队操作
        multi.decr(stockKey);//减去票的库存
        multi.sadd(userKey, uid);//将该用户加入到抢购成功对应的set集合中

        //执行
        List<Object> results = multi.exec();

        if (results == null || results.size() == 0) {
            System.out.println("抢票失败...");
            jedis.close();
            return false;
        }

        System.out.println("用户" + uid + "秒杀成功，" + ticketNo + "票已经售出");
        jedis.close();
        return true;
    }


}
