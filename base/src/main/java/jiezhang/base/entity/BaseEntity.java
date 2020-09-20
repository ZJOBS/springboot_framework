package jiezhang.base.entity;

import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.PrimaryTableId;
import jiezhang.base.utils.DataConversionUtil;
import jiezhang.base.utils.JsonUtil;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * @author ZhangJie
 * @description 基础类
 * @date 9:36 下午 2020/3/5
 * @return
 */
@Data
public class BaseEntity implements Serializable {
    protected String createUserName;

    protected String updateUserName;

    protected Date createDate;

    protected Date updateDate;

    /**
     * 状态为多种时
     */
    protected String state;


    /**
     * 将对象转换为map
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> toMap() {
        return DataConversionUtil.toMapContainsNull(this);
    }

    /**
     * 对象转Map，剔除value等于null的属性
     *
     * @return
     */
    public Map<String, Object> toMapExclusiveNull() {
        return DataConversionUtil.toMapExclusiveNull(this);
    }


    /**
     * 将对象转为JSON
     *
     * @return
     */
    public String toJSON() {
        return JsonUtil.mapToJson(toMap());
    }

    /**
     * 将Map值设置到对象中,map的值
     */
    public void assignment(Map<String, Object> data) {
        Method[] methods = this.getClass().getMethods();
        try {
            for (Method method : methods) {
                if (method.getName().startsWith("set")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("set") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    method.invoke(this, new Object[]{data.get(field)});
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库主键字段的Field,通过@ID标记
     */
    protected Field gainIdField() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                return field;
            }
        }
        throw new RuntimeException("undefine POJO @Id");
    }


    /**
     * 获取ID值
     *
     * @return
     */
    public Object gainKeyValue() {
        Field idField = gainIdField();
        String name = idField.getName();
        String methodName = "get" + name.toUpperCase().charAt(0) + name.substring(1);
        Method method = null;
        Object obj = null;
        try {
            method = this.getClass().getDeclaredMethod(methodName);
            obj = method.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("获取method方法失败。");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        }
        return obj;
    }

    /**
     * 设置ID
     *
     * @param id
     */
    public void putIdField(String id) {
        Field idField = gainIdField();
        String name = idField.getName();
        String methodName = "set" + name.toUpperCase().charAt(0) + name.substring(1);
        Method method = null;
        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            method = this.getClass().getDeclaredMethod(methodName, String.class);
            method.invoke(this, id);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("获取method方法失败。");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        }
    }

    /**
     * 获取关联
     *
     * @return
     */
    private Field gainPrimaryTableIdField() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(PrimaryTableId.class)) {
                return field;
            }
        }
        throw new RuntimeException("undefine POJO @Id");
    }
}
