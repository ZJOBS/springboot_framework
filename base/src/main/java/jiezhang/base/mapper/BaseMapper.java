package jiezhang.base.mapper;


import jiezhang.base.entity.BaseEntity;
import jiezhang.base.entity.DataTablePage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 增删改查通用Dao接口
 *
 * @param <T> 对象
 * @param <E> 异常
 * @author ZhangJie
 * @date 2018/02/09
 */
@Mapper
public interface BaseMapper<T extends BaseEntity, E extends Exception> {


    /**
     * 增
     *
     * @param parameter
     * @return
     * @throws E
     */
    public int insertEntity(Map<String, Object> parameter) throws E;

    /**
     * 删
     *
     * @param parameter
     * @return
     * @throws E
     */
    public int deleteEntity(Map<String, Object> parameter) throws E;

    /**
     * 改
     *
     * @param parameter
     * @return
     * @throws E
     */
    public int updateEntity(Map<String, Object> parameter) throws E;

    /**
     * 查询一条数据
     *
     * @param parameter
     * @return
     * @throws E
     */
    public T selectEntity(Map<String, Object> parameter) throws E;

    /**
     * 分页查询，第二版关联xml中生成的sql
     *
     * @param page
     * @return
     * @throws Exception
     */
    public List<T> queryDataTablePage(DataTablePage<T> page) throws Exception;


}
