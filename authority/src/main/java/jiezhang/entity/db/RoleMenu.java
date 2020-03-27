package jiezhang.entity.db;


import jiezhang.base.annotation.ForeignTableId;
import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.PrimaryTableId;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;

/**
 * 角色菜单表实体类
 *
 * @author ZhangJie
 * @date 2017/12/16
 */
@TableName(name = "system_role_menu")
public class RoleMenu extends BaseEntity {
    @Id
    private String roleMenuId;
    @PrimaryTableId
    private String roleId;
    @ForeignTableId
    private String menuId;

    public String getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "roleMenuId='" + roleMenuId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state='" + state + '\'' +
                '}';
    }
}
