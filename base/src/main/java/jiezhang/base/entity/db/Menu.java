package jiezhang.base.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.entity.BaseEntity;

import java.util.List;

/**
 * @author ZhangJie
 * @description
 * @date 9:45 下午 2020/3/5
 * @return
 */
public class Menu extends BaseEntity {
    @Id
    private int menuId;
    private String name;
    private String url;
    private String groupName;

    private List<Menu> sun;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Menu> getSun() {
        return sun;
    }

    public void setSun(List<Menu> sun) {
        this.sun = sun;
    }
}
