package jiezhang.entity.db;



import jiezhang.annotation.Id;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
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
