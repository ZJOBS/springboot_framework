package jiezhang.controller;

import jiezhang.base.controller.BaseBindAndNotBindController;
import jiezhang.base.entity.DataTablePage;
import jiezhang.entity.db.Admin;
import jiezhang.entity.db.AdminRole;
import jiezhang.entity.db.Role;
import jiezhang.entity.db.SystemLog;
import jiezhang.service.AdminRoleService;
import jiezhang.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 用户角色控制
 *
 * @author ZhangJie
 * @date 2018/02/08
 */
@SuppressWarnings("rawtypes")
@Controller
public class AdminRoleController extends BaseBindAndNotBindController<Admin, AdminRole, Role, Exception, AdminRoleService> {
    private final static Logger logger = LoggerFactory.getLogger(AdminRoleController.class);
    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "queryAdminBindRole")
    @ResponseBody
    public DataTablePage<Role> queryPage(Admin admin) {
        return super.queryBindDataTablePage(admin);
    }

    @RequestMapping(value = "queryAdminNotBindRole")
    @ResponseBody
    @Override
    public DataTablePage<Role> queryNotBindDataTablePage(Admin admin) {
        return super.queryNotBindDataTablePage(admin);
    }

    @RequestMapping(value = "bindAdminRole", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "管理员模块", methods = "绑定用户角色关系")
    public int bindAdminRole(String adminId, String roleIds) {
        int flag = 0;
        try {
            List<AdminRole> adminRoleList = new ArrayList<AdminRole>();
            String[] ids = roleIds.split(",");
            AdminRole adminRole;
            for (String id : ids) {
                adminRole = new AdminRole();
                adminRole.setRoleId(id);
                adminRole.setAdminId(adminId);
                adminRoleList.add(adminRole);
            }
            flag = adminRoleService.bind(adminRoleList);

            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "unbindAdminRole")
    @ResponseBody
    @SystemLog(module = "管理员模块", methods = "解绑用户角色关系")
    public int unbindAdminRole(String adminId, String roleIds) {
        int flag = 0;
        try {
            Map<String, Object> pmp = new HashMap<String, Object>(2);
            pmp.put("adminId", adminId);
            List<String> list = Arrays.asList(roleIds.split(","));
            pmp.put("list", list);
            flag = adminRoleService.unbind(pmp);

            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
