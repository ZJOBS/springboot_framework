package jiezhang.base.mapper;


import jiezhang.base.entity.db.Dict;

import java.util.List;

/**
 * 数据字典
 *
 * @author ZJOBS
 */
public interface DictMapper extends BaseMapper<Dict, Exception> {
    /**
     * 查询所有字典
     *
     * @return
     */
    public List<Dict> selectAll();
}
