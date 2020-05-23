package jiezhang.controller;

import jiezhang.entity.db.Menu;
import jiezhang.entity.db.SystemLog;
import jiezhang.service.MenuService;
import jiezhang.base.controller.BaseController;
import jiezhang.base.entity.DataTablePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制
 *
 * @author ZhangJie
 * @date 2015/3/10
 */
@SuppressWarnings("rawtypes")
@Controller
public class MenuController extends BaseController<Menu, MenuService> {

    @RequestMapping(value = "menuIndex")
    public String menu() {
        return "menu/index";
    }

    @RequestMapping(value = "queryMenu")
    @ResponseBody
    public DataTablePage<Menu> pageQueryMenu(Menu menu) {
        return pageQuery(menu);
    }

    @RequestMapping(value = "addMenu")
    @ResponseBody
    @SystemLog(module = "菜单模块", methods = "添加菜单")
    @Override
    public int add(Menu menu) {
        int flag = 0;
        try {
            flag = super.add(menu);
            service.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteMenu")
    @ResponseBody
    @SystemLog(module = "菜单模块", methods = "删除菜单")
    @Override
    public int delete(Menu menu) {
        int flag = 0;
        try {
            flag = super.delete(menu);
            //重新设置redis中的数据
            service.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateMenu")
    @ResponseBody
    @SystemLog(module = "菜单模块", methods = "修改菜单")
    @Override
    public int update(Menu menu) {
        int flag = 0;
        try {
            flag = super.update(menu);
            flag = service.modifyEntity(menu);
            //重新设置redis中的数据
            service.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
