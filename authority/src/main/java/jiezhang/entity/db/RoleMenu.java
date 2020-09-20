package jiezhang.entity.db;


import jiezhang.base.annotation.ForeignTableId;
import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.PrimaryTableId;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

/**
 * 角色菜单表实体类
 *
 * @author ZhangJie
 * @date 2017/12/16
 */
@TableName(name = "system_role_menu")
@Data
public class RoleMenu extends BaseEntity {
    @Id
    private String roleMenuId;
    @PrimaryTableId
    private String roleId;
    @ForeignTableId
    private String menuId;
}
