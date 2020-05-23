package jiezhang.service.impl;

import jiezhang.entity.db.Admin;
import jiezhang.entity.db.AdminRole;
import jiezhang.entity.db.Role;
import jiezhang.mapper.AdminRoleMapper;
import jiezhang.service.AdminRoleService;
import jiezhang.base.service.AbstractBindAndNotBindService;
import org.springframework.stereotype.Service;

/**
 * 用户角色服务实现类
 *
 * @author jiezhang
 * @date 2017/12/16
 */
@Service
public class AdminRoleServiceImpl extends AbstractBindAndNotBindService<Admin, AdminRole, Role, AdminRoleMapper, Exception> implements AdminRoleService {

}
