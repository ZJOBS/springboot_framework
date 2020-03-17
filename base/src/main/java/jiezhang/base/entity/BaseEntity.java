package jiezhang.base.entity;

import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.PrimaryTableId;
import jiezhang.base.utils.DataConversionUtil;
import jiezhang.base.utils.JsonUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author ZhangJie
 * @description 基础类
 * @date 9:36 下午 2020/3/5
 * @return
 */
public class BaseEntity implements Serializable {
    protected String createUserName;

    protected String updateUserName;

    protected Date createDate;

    protected Date updateDate;

    protected int sequence;

    protected String createDateStr;

    protected String updateDateStr;

    /**
     * 状态为多种时
     */
    protected String state;

    /**
     * 只有禁用和启用状态, checkbox没选中不会往后端传值，所以需要boolean的默认值
     */
    protected boolean activating;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        this.createDateStr = this.createDate == null ? "" : sdf.format(this.createDate);
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = new Date();
        this.updateDateStr = this.updateDate == null ? "" : sdf.format(this.updateDate);
    }

    public String getCreateDateStr() {
        return createDateStr;

    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean getActivating() {
        return activating;
    }

    public void setActivating(boolean activating) {
        this.activating = activating;
    }


    //    public Boolean getActivating() {
//        return activating;
//    }
//
//    public void setActivating(Boolean activating) {
//        this.activating = activating;
//    }

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
    private Field gainIdField() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : this.getClass().getDeclaredFields()) {
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
