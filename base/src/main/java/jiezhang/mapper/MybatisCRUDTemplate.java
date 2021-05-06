package jiezhang.mapper;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import jiezhang.annotation.Id;
import jiezhang.annotation.LogicDelete;
import jiezhang.annotation.State;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
import jiezhang.utils.DataConversionUtil;
import org.apache.ibatis.jdbc.SQL;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * mybatis 模板
 *
 * @author ZhangJie
 * @description
 * @date 2:59 下午 2020/3/26
 * @return
 */
public class MybatisCRUDTemplate<T extends BaseEntity> {
    public static final String start = "#{";

    public static final String end = "}";

    /**
     * insert
     *
     * @param obj
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 3:11 下午 2020/3/26
     */
    public String insertEntity(T obj) throws IllegalAccessException {
        List<Field> fields = getAllFiled(obj.getClass());
        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = DataConversionUtil.underline(field.getName());
            Object o = field.get(obj);
            if (o == null) {
                continue;
            }
            columns.add(columnName);
            values.add(new StringBuffer(start).append(field.getName()).append(end).toString());
        }
        return new SQL() {
            {
                INSERT_INTO(obj.getClass().getAnnotation(TableName.class).name());
                INTO_COLUMNS(ArrayUtil.toArray(columns, String.class));
                INTO_VALUES(ArrayUtil.toArray(values, String.class));
            }
        }.toString();
    }

    /**
     * 通过Id删除
     *
     * @param obj
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 4:14 下午 2020/3/26
     */
    public String deleteById(T obj) throws IllegalAccessException {
        return new SQL() {{
            List<Field> fields = getAllFiled(obj.getClass());
            DELETE_FROM(obj.getClass().getAnnotation(TableName.class).name());
            String column = null;
            for (Field field : fields) {
                field.setAccessible(true);
                String fileName = DataConversionUtil.underline(field.getName());
                if (field.isAnnotationPresent(Id.class)) {
                    column = new StringBuffer().append(fileName).append("=").append(start).append(field.getName()).append(end).toString();
                }
            }
            WHERE(column);
        }}.toString();
    }


    /**
     * 通过Id列表 批量删除
     *
     * @param list
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 12:04 下午 2020/12/10
     */
    public String deleteByIdList(Class clazz, List<Integer> list) throws IllegalAccessException {
        return new SQL() {{
            Field[] fields = clazz.getDeclaredFields();
            TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
            DELETE_FROM(tableName.name());
            String column = null;
            for (Field field : fields) {
                field.setAccessible(true);
                String fileName = DataConversionUtil.underline(field.getName());
                if (field.isAnnotationPresent(Id.class)) {
                    WHERE(new StringBuffer().append(fileName).append("in(").append(CollectionUtil.join(list, ",")).append(")").toString());
                }
            }
        }}.toString();
    }

    /**
     * 更新不为null的字段
     *
     * @param obj
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 4:14 下午 2020/3/26
     */
    public String updateEntityNotNulById(T obj) throws IllegalAccessException {
        List<Field> fields = getAllFiled(obj.getClass());
        return new SQL() {
            {
                UPDATE(obj.getClass().getAnnotation(TableName.class).name());
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fileName = DataConversionUtil.underline(field.getName());
                    Object o = field.get(obj);
                    if (o == null) {
                        continue;
                    }
                    StringBuffer buffer = new StringBuffer();
                    if (field.isAnnotationPresent(Id.class)) {
                        WHERE(buffer.append(fileName).append("=").append(start).append(field.getName()).append(end).toString());
                    } else {
                        SET(buffer.append(fileName).append(start).append(field.getName()).append(end).toString());
                    }
                }
            }
        }.toString();
    }

    /**
     * 启用（待测）
     *
     * @param clazz
     * @param id
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 9:51 上午 2020/12/17
     */
    public String openById(Class clazz, Object id) {
        List<Field> fields = getAllFiled(clazz);
        return new SQL() {{
            TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
            State state = (State) clazz.getAnnotation(State.class);
            for (Field field : fields) {
                field.setAccessible(true);
                String fileName = DataConversionUtil.underline(field.getName());
                StringBuffer buffer = new StringBuffer();
                if (field.isAnnotationPresent(State.class)) {
                    WHERE(buffer.append(fileName).append("=").append(start).append(field.getName()).append(end).toString());
                } else {
                    SET(buffer.append(fileName).append(start).append(state.openValue()).append(end).toString());
                }
            }
        }}.toString();
    }

    /**
     * 禁用(禁用)
     *
     * @param clazz
     * @param id
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 9:51 上午 2020/12/17
     */
    public String closeById(Class clazz, Object id) {
       List<Field> fields = getAllFiled(clazz);
        return new SQL() {{
            TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
            State state = (State) clazz.getAnnotation(State.class);
            for (Field field : fields) {
                field.setAccessible(true);
                String fileName = DataConversionUtil.underline(field.getName());
                StringBuffer buffer = new StringBuffer();
                if (field.isAnnotationPresent(State.class)) {
                    WHERE(buffer.append(fileName).append("=").append(start).append(field.getName()).append(end).toString());
                } else {
                    SET(buffer.append(fileName).append(start).append(state.closeValue()).append(end).toString());
                }
            }
        }}.toString();
    }


    /**
     * 通过类获取所有的字段，包含父类字段
     *
     * @param clazz
     * @return
     */
    private List<Field> getAllFiled(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }
}
