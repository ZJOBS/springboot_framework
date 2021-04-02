package jiezhang.mapper;


import jiezhang.entity.db.AdminRole;
import jiezhang.entity.db.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员角色数据处理接口
 *
 * @author jiezhang
 * @date 2017/3/14
 */
@Mapper
public interface AdminRoleMapper extends BaseBindAndNotBindMapper<Role, AdminRole, Exception> {


}
