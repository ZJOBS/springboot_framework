package jiezhang.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;

/**
 * @author ZhangJie
 * @date 2016/2/14
 */
@TableName(name = "system_admin")
public class Admin extends BaseEntity {
    @Id
    private String adminId;
    private Boolean activating;
    private String name;
    private String avatar;
    private String password;
    private String description;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Boolean getActivating() {
        return activating;
    }

    public void setActivating(Boolean activating) {
        this.activating = activating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", activating=" + activating +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state='" + state + '\'' +
                '}';
    }
}
