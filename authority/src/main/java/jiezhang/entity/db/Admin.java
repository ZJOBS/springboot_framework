package jiezhang.entity.db;



import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author ZhangJie
 * @date 2016/2/14
 */
@TableName(name = "system_admin")
@Data
public class Admin extends BaseEntity {
    @Id
    private String adminId;
    private Boolean activating;
    private String name;
    private String avatar;
    private String password;
    private String description;

}
