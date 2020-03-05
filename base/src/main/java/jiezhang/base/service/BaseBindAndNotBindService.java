package jiezhang.base.service;

import jiezhang.base.entity.BaseEntity;
import jiezhang.base.entity.DataTablePage;

import java.util.List;
import java.util.Map;

/**
 * 抽象服务接口
 *
 * @param <F>
 * @param <T>
 * @param <E>
 * @author jiezhang
 * @date 2018/02/09
 */
public interface BaseBindAndNotBindService<F extends BaseEntity, T extends BaseEntity, E extends Exception> {


    /**
     * 查询绑定信息
     *
     * @param parameters 请求参数
     * @param page
     * @return
     * @throws Exception
     */
    public DataTablePage queryBindDataTablePage(Map parameters, DataTablePage<F> page) throws Exception;


    /**
     * 查询绑定信息
     *
     * @param parameters 请求参数
     * @param page
     * @return
     * @throws Exception
     */
    public DataTablePage queryNotBindDataTablePage(Map parameters, DataTablePage<F> page) throws Exception;


    /**
     * 绑定
     *
     * @param list
     * @return int
     * @throws Exception
     */
    public int bind(List<T> list) throws Exception;

    /**
     * 接触绑定
     *
     * @param parameter
     * @return int
     * @throws Exception
     */
    public int unbind(Map parameter) throws Exception;

}
