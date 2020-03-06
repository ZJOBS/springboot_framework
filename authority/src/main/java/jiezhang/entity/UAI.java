package jiezhang.entity;

import jiezhang.entity.db.Admin;

import java.io.Serializable;

/**
 * @author ZhangJie
 * @date 2016/3/14
 */
public class UAI implements Serializable {
    /**
     * 用户ID
     */
    private String adminId;
    /**
     * 用户名
     */
    private String adminName;
    /**
     * 角色Id
     */
    private int roleId;
    /**
     * 角色名
     */
    private String roleName;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public void setAdmin(Admin admin) {
        this.adminId = admin.getAdminId();
        this.adminName = admin.getName();
    }

    @Override
    public String toString() {
        return "UAI{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
