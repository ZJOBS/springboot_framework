package jiezhang.entity.db;


import jiezhang.annotation.Id;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
import lombok.Data;

/**
 * Created by jiezhang on 2017/6/13.
 */
@TableName(name = "system_menu")
@Data
public class Menu extends BaseEntity {
    @Id
    private String menuId;
    private String parentId;
    private Boolean activating;
    private String name;
    private String url;
    private String image;
    private Boolean leaf;

}
