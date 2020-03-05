package jiezhang.base.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.entity.BaseEntity;

/**
 * 字典对象
 *
 * @author jiezhang
 */
public class Dict extends BaseEntity {
    public static String STATE_DEFAULT = "0";
    @Id
    private String dictId;
    private String parentId;
    private String code;
    private String value;
    private String name;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "dictId='" + dictId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
//                ", id='" + id + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sequence=" + sequence +
                ", createDateStr='" + createDateStr + '\'' +
                ", updateDateStr='" + updateDateStr + '\'' +
                ", state=" + state +
                ", activating=" + activating +
                '}';
    }
}
