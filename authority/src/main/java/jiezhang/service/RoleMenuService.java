package jiezhang.service;


import jiezhang.entity.db.Menu;
import jiezhang.entity.db.Role;
import jiezhang.entity.db.RoleMenu;

/**
 * 角色菜单接口
 *
 * @author jiezhang
 * @date 2017/12/16
 */
public interface RoleMenuService extends BaseBindAndNotBindService<Role, RoleMenu, Menu, Exception> {
}
