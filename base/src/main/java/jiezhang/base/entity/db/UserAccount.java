package jiezhang.base.entity.db;


import jiezhang.base.constant.UserAccountConstant;
import jiezhang.base.entity.BaseEntity;

/**
 * 用户
 * Created by ZJOBS on 2015/3/10.
 */
public class UserAccount extends BaseEntity {
    private Long userAccountId;
    private String name;
    private String sex;
    private String email;
    private String password;
    private int category;
    private Boolean isActivating;
    private String isActivatingStr;
    private String description;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Boolean getIsActivating() {
        return isActivating;
    }

    public void setIsActivating(Boolean isActivating) {
        this.isActivating = isActivating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsActivatingStr() {
        return isActivatingStr;
    }

    public void setIsActivatingStr(String isActivatingStr) {
        this.isActivatingStr = isActivatingStr;
        //this.isActivatingStr = this.isActivating.equals("0") ? "已激活" : "未激活";
    }

    public boolean isClient() {
        return this.getCategory() == UserAccountConstant.CLIENT ? true : false;
    }

    public boolean isAdministrator() {
        return this.getCategory() == UserAccountConstant.ADMINISTRATOR ? true : false;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userAccountId=" + userAccountId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", category=" + category +
                ", isActivating=" + isActivating +
                ", isActivatingStr='" + isActivatingStr + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
