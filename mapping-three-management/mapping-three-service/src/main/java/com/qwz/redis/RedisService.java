package com.qwz.redis;

import com.qwz.utils.JSONUtils;
import com.qwz.utils.StringUtils;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.qwz.staticproperties.RedisProperties.*;
//
//@Service
public class RedisService<T> {

    private RedisSerializer keySerializer = null;

    /**
     * @author Seven Lee
     * @description
     *      初始化redis的key序列化器
     * @param
     * @date 2020/7/10
     * @return void
     * @throws
     **/
    @PostConstruct
    public void initRedisSerializer() {
        if(this.keySerializer == null) {
            this.keySerializer = new JdkSerializationRedisSerializer(this.getClass().getClassLoader());
        }
    }

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 向redis中插入数据
     *
     * nxxx:
     *              是固定值，有两个值
     *              "nx":
     *                    如果redis中的key不存在，则就可以存储，如果redis中已经有这个key了，则不存数据
     *              "xx":
     *                   如果redis中的key存在，则直接覆盖，如果key不存在则不存
     *
     *           eg:
     *               研发组有两个人，一个是张三，一个是李四
     *               张三负责商品管理的代码编写
     *               李四负责订单管理
     *               张三和李四因为数据量过大都会使用到redis
     *               张三---->redis.set("goods", 商品信息);
     *               李四---->redis.set("goods", 订单信息);
     *               张三---->redis.get("goods")--->订单信息---->转换异常
     *
     *               张三负责商品管理的代码编写
     *               张三---->redis.set("goods", 商品信息);
     *                  张三---->redis.set("goods", 商品信息);
     *
     *         expx:
     *          值也是固定的
     *          只有两个值:
     *              ex:
     *                  失效时间的单位是秒
     *              px:
     *                   失效时间的单位是毫秒
     *
     *          seconds:
     *               失效时间
     **/
    public String set(String key, T value, String nxxx, String expx, Integer seconds){
        if(null != seconds && 0 < seconds && NX.equals(nxxx) || XX.equals(nxxx) && EX.equals(expx) || PX.equals(expx)){
            //说欧明需要设置失效时间
            return jedisCluster.set(key, JSONUtils.toJsonString(value),nxxx,expx,seconds);
        }else{
            //不需要设置失效时间
            //但是仍然需要判断用户传递的是nx还是xx
            if (NX.equals(nxxx)){
                return String.valueOf(jedisCluster.setnx(key,JSONUtils.toJsonString(value)));
            }else if (XX.equals(nxxx)){
                return jedisCluster.set(key,JSONUtils.toJsonString(value));
            }
        }
        return NO;
    }

    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 从redis中获取一个数据
     **/

    public T getone(String key){
        return (T) JSONUtils.toObject(jedisCluster.get(key),Object.class);
    }

    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 从redis中查询一个数据 values是字符串
     **/

    public String getString(String key){
        return jedisCluster.get(key);
    }

    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 从redis中查询集合数据
     **/

    public List<T> getList(String key){
        return (List<T>) JSONUtils.toObject(jedisCluster.get(key),Object.class);
    }
    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 从redis删除数据
     **/
    public Long delone(Object key){
        return jedisCluster.del(rawKey(key));
    }

    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 删除多条数据
     **/

    public Long delMany(Collection<T> keys){
        if (CollectionUtils.isEmpty(keys)){
            return 0L;
        }else{
            byte[] bytes = rawKey(keys);
            return jedisCluster.del(bytes);
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/10
     * @desc
     * 把Object转换为字节数据
     **/
    private byte[] rawKey(Object key) {
        // 1.判断
        /**
         * 断言就是来判断用的:
         *  如果key有值则会去执行下面的代码
         *  如果key没有，则直接return了
         */
        /*if(key == null) {
            System.out.println("key不存在");
            return null;
        } else {
            if(keySerializer == null && key instanceof byte[]) {
                // 直接转换
                return (byte[]) key;
            } else {
                // 说明条件不满足，需要进行转换
                return keySerializer.serialize(key);
            }
        }*/
        Assert.notNull(key, "non null key required");
        /*if(keySerializer == null && key instanceof byte[]) {
            // 直接转换
            return (byte[]) key;
        } else {
            // 说明条件不满足，需要进行转换
            return keySerializer.serialize(key);
        }*/
        return this.keySerializer == null && key instanceof byte[] ?
                (byte[]) key : this.keySerializer.serialize(key);
    }

    private byte[][] rawkeys(Collection<T> keys) {
        byte[][] rks = new byte[keys.size()][];
        int i = 0;
        Object key;
        for(Iterator i9 = keys.iterator(); i9.hasNext(); rks[i++] = this.rawKey(key)) {
            key = i9.next();
        }
        return rks;
    }


}
