package jiezhang.base.service;


import jiezhang.base.entity.db.RedisEntity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiezhang on 2017/6/20.
 */
public interface RedisService<T extends RedisEntity> {

    /**
     * 存入或添加一个对象。当objKey中已经包含一个id时，替换原有的；当objKey中并不包含id时，则添加一条新的
     *
     * @param objKey 库名
     * @param id     唯一键
     * @param obj    需要插入的对象
     * @throws Exception 异常
     */
    void put(String objKey, String id, Object obj) throws Exception;

    /**
     * 存入一个对象,并指定保存时间。当objKey中已经包含一个id时，替换原有的；当objKey中并不包含id时，则添加一条新的
     *
     * @param objKey     库名
     * @param id         唯一键
     * @param expireTime 保存时间，单位毫秒
     * @param obj        需要插入的对象
     * @throws Exception 异常
     */
    void put(String objKey, String id, Long expireTime, Object obj) throws Exception;

    /**
     * 存入一个Map对象
     *
     * @param objKey
     *            库名
     * @param id
     *            唯一键
     * @param map
     *            需要插入的对象
     * @throws Exception
     *             异常
     */
    // void put(String objKey, String id, Map map) throws Exception;

    /**
     * 存入一整个list
     *
     * @param objKey
     *            库名
     * @param id
     *            唯一键
     * @param list
     *            整个list
     * @throws Exception
     *             异常
     */
    // void put(String objKey, String id, List list) throws Exception;

    /**
     * 通过Id和objKey查询一个对象
     *
     * @param objKey 库名
     * @param id     唯一键
     * @return 查询到的对象
     * @throws Exception 异常
     */
    Object get(String objKey, String id) throws Exception;

    /**
     * 通过Id和objKey查询一个Map对象
     *
     * @param objKey 库名
     * @param id     唯一键
     * @return Map对象
     * @throws Exception
     */
    Map getMap(String objKey, String id) throws Exception;

    /**
     * 通过objKey和id查询一个List对象
     *
     * @param objKey 库名
     * @param id     唯一键
     * @return List对象
     * @throws Exception
     */
    List getList(String objKey, String id) throws Exception;

    /**
     * 通过objKey和id删除一个对象
     *
     * @param objKey 库名
     * @param id     唯一键
     * @throws Exception 异常
     */
    void delete(String objKey, String id) throws Exception;

    /**
     * 通过objKey查找一个List对象
     *
     * @param objKey 库名
     * @return 库下所有的对象
     * @throws Exception 异常
     */
    List<T> getObjects(String objKey) throws Exception;

//    /**
//     * 加锁
//     *
//     * @param lockName 锁名
//     * @param time     加锁时间,单位为秒
//     */
//    public void lock(String lockName, int time);
//
//    /**
//     * 加锁
//     *
//     * @param lockName 锁名
//     * @param time     加锁时间
//     * @param unit     单位
//     */
//    public void lock(String lockName, int time, TimeUnit unit);
//
//    /**
//     * 解锁
//     *
//     * @param lockName 锁名
//     */
//    public void unLock(String lockName);
//
//    /**
//     * 获取序号
//     *
//     * @name 序号名称
//     * 锁名
//     */
//    public Long getSerialNum(String name) throws Exception;
}
