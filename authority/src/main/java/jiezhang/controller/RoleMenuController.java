package jiezhang.controller;

import jiezhang.entity.DataTablePage;
import jiezhang.entity.db.Menu;
import jiezhang.entity.db.Role;
import jiezhang.entity.db.RoleMenu;
import jiezhang.entity.db.SystemLog;
import jiezhang.service.MenuService;
import jiezhang.service.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 角色菜单控制层
 *
 * @author jiezhang
 */
@SuppressWarnings("rawtypes")
@Controller
public class RoleMenuController extends BaseBindAndNotBindController<Role, RoleMenu, Menu, Exception, RoleMenuService> {
    private final static Logger logger = LoggerFactory.getLogger(RoleMenuController.class);

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "queryRoleBindMenu")
    @ResponseBody
    @Override
    public DataTablePage<Menu> queryBindDataTablePage(Role role) {
        return super.queryBindDataTablePage(role);
    }

    @RequestMapping(value = "queryRoleNotBindMenu")
    @ResponseBody
    @Override
    public DataTablePage<Menu> queryNotBindDataTablePage(Role role) {
        return super.queryNotBindDataTablePage(role);
    }


    @RequestMapping(value = "bindRoleMenu", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "绑定菜单")
    public int bindRoleMenu(String roleId, String menuIds) {
        int flag = 0;
        try {
            List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
            String[] ids = menuIds.split(",");
            RoleMenu roleMenu;
            for (String id : ids) {
                roleMenu = new RoleMenu();
                roleMenu.setMenuId(id);
                roleMenu.setRoleId(roleId);
                roleMenuList.add(roleMenu);
            }
            flag = roleMenuService.bind(roleMenuList);

            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "unbindRoleMenu")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "解绑菜单")
    public int unbindRoleMenu(String roleId, String menuIds) {
        int flag = 0;
        try {
            Map<String, Object> pmp = new HashMap<String, Object>(2);
            pmp.put("roleId", roleId);
            List<String> list = Arrays.asList(menuIds.split(","));
            pmp.put("list", list);
            flag = roleMenuService.unbind(pmp);

            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
