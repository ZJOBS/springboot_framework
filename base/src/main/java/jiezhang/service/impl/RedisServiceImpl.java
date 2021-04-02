package jiezhang.service.impl;


import jiezhang.entity.db.RedisEntity;
import jiezhang.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiezhang on 2017/6/20.
 */
@Service
public class RedisServiceImpl<T extends RedisEntity> implements RedisService<T> {
    private static String masterName;
    private static String host;
    private static String port;
    private static Long maxSerial;

//    @Autowired
//            (required = false)
//    private RedisConf redisConf;
//
//    public RedisConf getRedisConf() {
//        return redisConf;
//    }
//
//    public void setRedisConf(RedisConf redisConf) {
//        this.redisConf = redisConf;
//    }

    @Autowired
    private RedisTemplate redisTemplate;


    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static String getMasterName() {
        return masterName;
    }

    public static void setMasterName(String masterName) {
        RedisServiceImpl.masterName = masterName;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        RedisServiceImpl.host = host;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        RedisServiceImpl.port = port;
    }

    public static Long getMaxSerial() {
        return maxSerial;
    }

    public static void setMaxSerial(Long maxSerial) {
        RedisServiceImpl.maxSerial = maxSerial;
    }

    @Override
    public void put(String objKey, String id, Object obj) throws Exception {
        redisTemplate.boundHashOps(objKey).put(id, obj);
    }

    @Override
    public void put(String objKey, String id, Long expireTime, Object obj) throws Exception {
        redisTemplate.boundHashOps(objKey).put(id, obj);
        redisTemplate.expire(objKey, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public Object get(String objKey, String id) throws Exception {
        return (Object) redisTemplate.boundHashOps(objKey).get(id);
    }

    @Override
    public Map getMap(String objKey, String id) throws Exception {
        return (Map) redisTemplate.boundHashOps(objKey).get(id);
    }

    @Override
    public List getList(String objKey, String id) throws Exception {
        return (List) redisTemplate.boundHashOps(objKey).get(id);
    }

    @Override
    public void delete(String objKey, String id) throws Exception {
        redisTemplate.boundHashOps(objKey).delete(id);
    }

    // @Override
    @Override
    public List<T> getObjects(String objKey) throws Exception {
        List<T> list = new ArrayList<T>();
        List<Object> objs = redisTemplate.boundHashOps(objKey).values();
        for (Object obj : objs) {
            list.add((T) obj);
        }
        return list;
    }

//    @Override
//    public void lock(String lockName, int time) {
//        RLock rLock = redisConf.getRedisson().getLock(lockName);
//        rLock.lock(time, TimeUnit.SECONDS);
//    }
//
//    @Override
//    public void lock(String lockName, int time, TimeUnit unit) {
//        RLock rLock = redisConf.getRedisson().getLock(lockName);
//        rLock.lock(time, unit);
//    }
//
//    @Override
//    public void unLock(String lockName) {
//        Redisson redisson = redisConf.getRedisson();
//        RLock rLock = redisson.getLock(lockName);
//        rLock.unlock();
//    }
//
//    @Override
//    public Long getSerialNum(String name) throws Exception {
//        // 获取当前，如果==最大值时，锁定
//        lock("ser3", 1);
//        Long serial = redisConf.getRedisson().getAtomicLong(name).addAndGet(1);
//        if (serial > redisConf.getMaxSerial()) {
//            redisConf.getRedisson().getAtomicLong(name).set(0);
//            serial = redisConf.getRedisson().getAtomicLong(name).addAndGet(1);
//        }
//        unLock("ser3");
//        return serial;
//    }
}
