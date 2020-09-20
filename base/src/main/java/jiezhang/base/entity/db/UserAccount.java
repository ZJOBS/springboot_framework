package jiezhang.base.entity.db;


import jiezhang.base.constant.UserAccountConstant;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

/**
 * 用户
 * Created by ZJOBS on 2015/3/10.
 */
@Data
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



    public boolean isClient() {
        return this.getCategory() == UserAccountConstant.CLIENT ? true : false;
    }

    public boolean isAdministrator() {
        return this.getCategory() == UserAccountConstant.ADMINISTRATOR ? true : false;
    }


}
