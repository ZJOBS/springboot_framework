package jiezhang.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
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
