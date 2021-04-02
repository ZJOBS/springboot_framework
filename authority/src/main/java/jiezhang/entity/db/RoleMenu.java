package jiezhang.entity.db;


import jiezhang.annotation.ForeignTableId;
import jiezhang.annotation.Id;
import jiezhang.annotation.PrimaryTableId;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
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
