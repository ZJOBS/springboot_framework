package jiezhang.service;


import jiezhang.entity.db.Admin;
import jiezhang.entity.db.AdminRole;
import jiezhang.entity.db.Role;
import jiezhang.base.service.BaseBindAndNotBindService;

/**
 * 用户角色服务接口
 *
 * @author jiezhang
 * @date 2017/12/16
 */
public interface AdminRoleService extends BaseBindAndNotBindService<Admin, AdminRole, Role, Exception> {

}
