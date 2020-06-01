package jiezhang.base.constant;

/**
 * 数据库
 *
 * @author ZhangJie
 * @date 1:52 下午 2020/6/1
 */
public enum DataBase {
    MYSQL("MYSQL"), ORALCE("ORALCE");
    private String name;

    DataBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkName(String str) {
        return this.getName().equalsIgnoreCase(str);
    }
}
