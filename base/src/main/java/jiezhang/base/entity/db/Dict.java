package jiezhang.base.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

/**
 * 字典对象
 *
 * @author jiezhang
 */
@TableName(name = "system_dictionary")
@Data
public class Dict extends BaseEntity {
    @Id
    private String dictId;
    private String parentId;
    private Boolean activating;
    private String code;
    private String value;
    private String name;
}
