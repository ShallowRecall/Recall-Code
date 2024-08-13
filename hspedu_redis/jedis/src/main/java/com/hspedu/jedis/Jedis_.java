package com.hspedu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jedis_ {

    // 连接Redis
    //1. 如果Redis配置了密码，则需要进行身份校验
    //2. 因为需要连接到redis端口，比如6379，就需要配置防火墙，放开端口
    //3. 注意修改bind，支持远程连接.
    @Test
    public void con() {
        Jedis jedis = new Jedis("192.168.150.102", 6379);
        jedis.auth("foobared");
        String res = jedis.ping();
        System.out.println("连接成功 ping 返回结果=" + res);
        jedis.close(); //关闭当前连接，注意并没有关闭Redis
    }

    //key操作
    @Test
    public void key() {

        Jedis jedis = new Jedis("192.168.150.102", 6379);

        jedis.auth("foobared");
        // 设置key
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");

        // 获取key
        Set<String> keys = jedis.keys("*");

        for (String key : keys) {
            System.out.println("key==>" + key);
        }

        // 判断key是否存在，ttl
        System.out.println(jedis.exists("k1"));//T
        System.out.println(jedis.ttl("k2"));//-1
        System.out.println(jedis.get("k3"));//v3

        // 关闭连接
        jedis.close();

    }

    //string
    @Test
    public void string(){

        Jedis jedis = new Jedis("192.168.150.102", 6379);

        jedis.auth("foobared");
        // 批量设置k-v
        jedis.mset("k1","jack","k2","scoot","k3","hsp");
        // 批量获取
        List<String> mget = jedis.mget("k1", "k2");
        for (String s : mget) {
            System.out.println("s==>" + s);
        }

        // 关闭连接
        jedis.close();
    }

    //list
    @Test
    public void list(){
        Jedis jedis = new Jedis("192.168.150.102", 6379);
        jedis.auth("foobared");
        //添加list数据
        jedis.lpush("name_list", "jack", "tom", "nono");
        List<String> name_list = jedis.lrange("name_list", 0, -1);
        for (String s : name_list) {
            System.out.println("s==>" + s);
        }

        // 关闭连接
        jedis.close();
    }

    //set
    @Test
    public void set(){

        Jedis jedis = new Jedis("192.168.150.102", 6379);
        jedis.auth("foobared");

        jedis.sadd("city","北京","上海");
        jedis.sadd("city","广州");
        jedis.sadd("city","深圳");

        Set<String> smembers = jedis.smembers("city");

        for (String s : smembers) {
            System.out.println("s==>" + s);
        }

        jedis.close();

    }

    //hash
    @Test
    public void hash(){

        Jedis jedis = new Jedis("192.168.150.102", 6379);
        jedis.auth("foobared");

        //设置
        jedis.hset("hash01","name","李白");
        jedis.hset("hash01","age","30");

        //获取
        String name = jedis.hget("hash01", "name");
        System.out.println("name==>" + name);

        //先构建一个map，然后加入
        Map<String, String> maps = new HashMap<>();
        maps.put("job","Java工程师");
        maps.put("name","smith");
        maps.put("email","smith@hqq.com");
        jedis.hset("hash02",maps);

        //取出
        List<String> person = jedis.hmget("hash02", "job", "name", "email");
        for (String s : person) {
            System.out.println("s==>" + s);
        }

        jedis.close();
    }

    //zset-有序集合
    @Test
    public void zset(){

        Jedis jedis = new Jedis("192.168.150.102", 6379);
        jedis.auth("foobared");

        //添加
        jedis.zadd("hero",1,"关羽");
        jedis.zadd("hero",2,"张飞");
        jedis.zadd("hero",3,"赵云");
        jedis.zadd("hero",4,"马超");
        jedis.zadd("hero",5,"黄忠");

        //取出
        //Set<String> heroes = jedis.zrange("hero", 0, -1);//按照评分从小到大
        Set<String> heroes = jedis.zrevrange("hero", 0, -1);//按照评分从大到小
        for (String hero : heroes) {
            System.out.println("hero==>" + hero);
        }

        jedis.close();

    }

}
