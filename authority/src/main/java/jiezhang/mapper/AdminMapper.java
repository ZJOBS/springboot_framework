package jiezhang.mapper;


import jiezhang.entity.db.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员数据处理接口
 *
 * @author jiezhang
 * @date 2017/3/14
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin, Exception> {

    /**
     * 查询所有管理员
     *
     * @return
     */
    public List<Admin> selectAll();
}
