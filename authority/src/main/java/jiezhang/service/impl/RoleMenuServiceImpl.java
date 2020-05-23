package jiezhang.service.impl;

import jiezhang.entity.db.Menu;
import jiezhang.entity.db.Role;
import jiezhang.entity.db.RoleMenu;
import jiezhang.mapper.RoleMenuMapper;
import jiezhang.service.RoleMenuService;
import jiezhang.base.service.AbstractBindAndNotBindService;
import org.springframework.stereotype.Service;

/**
 * 角色菜单服务实现类
 *
 * @author jiezhang
 */
@Service
public class RoleMenuServiceImpl extends AbstractBindAndNotBindService<Role, RoleMenu, Menu, RoleMenuMapper, Exception> implements RoleMenuService {
}
