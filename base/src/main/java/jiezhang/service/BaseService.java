package jiezhang.service;


import jiezhang.entity.BaseEntity;
import jiezhang.entity.DataTablePage;

import java.util.Map;

/**
 * 抽象服务接口
 *
 * @author jiezhang
 * @date 2017/6/13
 */
public interface BaseService<T extends BaseEntity, E extends Exception> {

    /**
     * 添加
     *
     * @param entity
     * @return int 0失败，1成功
     * @throws Exception 异常
     */
    public int createEntity(T entity) throws E;

    /**
     * 移除
     *
     * @param entity
     * @return int 0失败，1成功
     * @throws Exception 异常
     */
    public int removeEntity(T entity) throws E;

    /**
     * 修改
     *
     * @param entity
     * @return int 0失败，1成功
     * @throws Exception 异常
     */
    public int modifyEntity(T entity) throws E;

    /**
     * 查询
     *
     * @param entity 需要查询的参数
     * @return T 返回数据类型和传入类型一致
     * @throws Exception 异常
     */
    public T findEntity(T entity) throws E;

    /**
     * 分页查询
     *
     * @param parameters 参数
     * @param page       分页信息
     * @return DataTablePage 分页后的数据
     * @throws Exception 异常
     */
    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception;

    /**
     * 禁用
     *
     * @param entity 禁用对象，必须包含State属性
     * @return int 0失败，1成功
     * @throws Exception 异常
     */
    public int disable(T entity) throws Exception;

    /**
     * 启用
     *
     * @param entity 启用对象，必须包含State属性
     * @return int 0失败，1成功
     * @throws Exception 异常
     */
    public int enable(T entity) throws Exception;
}
