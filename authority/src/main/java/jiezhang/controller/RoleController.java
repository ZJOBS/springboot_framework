package jiezhang.controller;

import jiezhang.entity.db.Role;
import jiezhang.entity.db.SystemLog;
import jiezhang.service.MenuService;
import jiezhang.service.RoleService;
import jiezhang.base.controller.BaseController;
import jiezhang.base.entity.DataTablePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangJie on 2016/3/17.
 */
@SuppressWarnings("rawtypes")
@Controller
public class RoleController extends BaseController<Role, RoleService> {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "roleIndex")
    public String role() {
        return "role/index";
    }

    @RequestMapping(value = "queryRole")
    @ResponseBody
    public DataTablePage<Role> pageQueryRole(Role role) {
        return super.pageQuery(role);
    }


    @RequestMapping(value = "addRole")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "添加角色")
    public int addRole(Role role) {
        return super.add(role);
    }


    @RequestMapping(value = "deleteRole")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "删除角色")
    public int deleteRole(Role role) {
        return super.delete(role);
    }


    @RequestMapping(value = "updateRole")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "添加角色")
    public int updateRole(Role role) {
        int flag = 0;
        try {
            flag = super.update(role);
            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
