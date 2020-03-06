package jiezhang.mapper;


import jiezhang.entity.db.Menu;
import jiezhang.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单数据处理接口
 *
 * @author jiezhang
 * @date 2017/3/14
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu, Exception> {

    /**
     * 查询所有菜单
     *
     * @param map
     * @return
     */
    public List<Menu> getList(Map<String, Object> map);

    /**
     * 查询管理员的菜单
     *
     * @param map
     * @return
     */
    public List<Menu> selectMenuByAdminId(Map<String, Object> map);

}
