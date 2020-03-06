package jiezhang.mapper;


import jiezhang.entity.db.Menu;
import jiezhang.entity.db.RoleMenu;
import jiezhang.base.mapper.BaseBindAndNotBindMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色菜单数据处理接口
 *
 * @author jiezhang
 */
@Mapper
public interface RoleMenuMapper extends BaseBindAndNotBindMapper<Menu, RoleMenu, Exception> {
}
