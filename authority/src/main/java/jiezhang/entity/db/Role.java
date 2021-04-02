package jiezhang.entity.db;


import jiezhang.annotation.Id;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
import lombok.Data;

/**
 * Created by jiezhang on 2017/6/15.
 */
@TableName(name = "system_role")
@Data
public class Role extends BaseEntity {
    @Id
    private String roleId;
    private String name;
    private Boolean activating;
    private String description;
}
