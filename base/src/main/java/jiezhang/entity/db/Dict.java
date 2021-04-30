package jiezhang.entity.db;


import jiezhang.annotation.Id;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
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
