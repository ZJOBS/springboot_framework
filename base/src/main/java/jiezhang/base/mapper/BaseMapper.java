package jiezhang.base.mapper;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import jiezhang.base.entity.DataTablePage;
import jiezhang.base.entity.db.Dict;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.lang.reflect.Field;
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
     * @param t
     * @return int
     * @author ZhangJie
     * @description
     * @date 3:37 下午 2020/3/26
     */
    @InsertProvider(type = MybatisCRUDTemplate.class, method = "generateInsertSql")
    public int insertEntity(T t);

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
