package jiezhang.entity.db;


import jiezhang.base.annotation.ForeignTableId;
import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.PrimaryTableId;
import jiezhang.base.entity.BaseEntity;

/**
 * 角色用户表实体类
 *
 * @author ZhangJie
 * @date 2017/6/21
 */
public class AdminRole extends BaseEntity {
    @Id
    private String adminRoleId;
    @PrimaryTableId
    private String adminId;
    @ForeignTableId
    private String roleId;

    public String getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(String adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "adminRoleId='" + adminRoleId + '\'' +
                ", adminId='" + adminId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sequence=" + sequence +
                ", createDateStr='" + createDateStr + '\'' +
                ", updateDateStr='" + updateDateStr + '\'' +
                ", state='" + state + '\'' +
                ", activating=" + activating +
                '}';
    }
}
