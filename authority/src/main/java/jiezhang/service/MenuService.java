package jiezhang.service;

import jiezhang.entity.db.Menu;
import com.alibaba.fastjson.JSONArray;
import jiezhang.base.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 菜单服务接口
 *
 * @author jiezhang
 * @date 2015/3/10
 */
public interface MenuService extends BaseService<Menu, Exception> {

    public List<Menu> getList(Map<String, Object> map);

    public JSONArray getTreeMenu();

    public void updateRedisMenu() throws Exception;

}
