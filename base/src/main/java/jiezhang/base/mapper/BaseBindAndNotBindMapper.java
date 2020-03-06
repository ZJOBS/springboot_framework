package jiezhang.base.mapper;


import jiezhang.base.entity.BaseEntity;
import jiezhang.base.entity.DataTablePage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 绑定与未绑定Dao
 *
 * @param <F>辅表
 * @param <T>中间表
 * @param <E>自定义异常
 * @author ZhangJie
 * @date 2018/02/08
 */
@Mapper
public interface BaseBindAndNotBindMapper<F extends BaseEntity, T extends BaseEntity, E extends Exception> {

    /**
     * 查询绑定信息
     *
     * @param page 分页信息
     * @return List
     * @throws Exception
     */
    public List<F> queryBindDataTablePage(DataTablePage<F> page) throws Exception;

    /**
     * 查询未绑定信息
     *
     * @param page 分页信息
     * @return List
     * @throws Exception
     */
    public List<F> queryNotBindDataTablePage(DataTablePage<F> page) throws Exception;

    /**
     * 批量插入
     *
     * @param list 参数
     * @return int 插入条数
     * @throws Exception
     */
    public int insertList(List<T> list) throws Exception;

    /**
     * 批量删除
     *
     * @param parameter 参数
     * @return int 删除条数
     * @throws Exception
     */
    public int removeList(Map parameter) throws Exception;
}
