package jiezhang.mapper;


import jiezhang.entity.db.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据字典
 *
 * @author ZJOBS
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict, Exception> {
    /**
     * 查询所有字典
     *
     * @return
     */
    public List<Dict> selectAll();
}
