package jiezhang.mapper;


import jiezhang.entity.db.Role;
import jiezhang.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色数据处理接口
 *
 * @author jiezhang
 * @date 2017/6/15
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role, Exception> {
}
