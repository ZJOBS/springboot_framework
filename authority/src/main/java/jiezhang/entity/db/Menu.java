package jiezhang.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;

/**
 * Created by jiezhang on 2017/6/13.
 */
@TableName(name = "system_menu")
public class Menu extends BaseEntity {
    @Id
    private String menuId;
    private String parentId;
    private Boolean activating;
    private String name;
    private String url;
    private String image;
    private Boolean leaf;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getActivating() {
        return activating;
    }

    public void setActivating(Boolean activating) {
        this.activating = activating;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", activating=" + activating +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", leaf=" + leaf +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state='" + state + '\'' +
                '}';
    }
}
