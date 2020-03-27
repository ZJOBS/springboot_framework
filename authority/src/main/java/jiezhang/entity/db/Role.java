package jiezhang.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;

/**
 * Created by jiezhang on 2017/6/15.
 */
@TableName(name = "system_role")
public class Role extends BaseEntity {
    @Id
    private String roleId;
    private String name;
    private Boolean activating;
    private String description;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivating() {
        return activating;
    }

    public void setActivating(Boolean activating) {
        this.activating = activating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                ", activating=" + activating +
                ", description='" + description + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state='" + state + '\'' +
                ", activating=" + activating +
                '}';
    }
}
