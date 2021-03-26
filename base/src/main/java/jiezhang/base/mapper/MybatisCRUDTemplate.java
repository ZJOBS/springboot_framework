package jiezhang.base.mapper;

import cn.hutool.core.collection.CollUtil;
import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.LogicDelete;
import jiezhang.base.annotation.State;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import jiezhang.base.utils.DataConversionUtil;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * mybatis 模板
 *
 * @author ZhangJie
 * @description
 * @date 2:59 下午 2020/3/26
 * @return
 */
public class MybatisCRUDTemplate<T extends BaseEntity> {

    /**
     * 生成insert语句
     *
     * @param
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 3:11 下午 2020/3/26
     */
    public String generateInsertSql(T obj) throws IllegalAccessException {
        StringBuffer sql = new StringBuffer();
        obj.getClass().getAnnotation(TableName.class);
        sql.append("INSERT INTO ")
                .append(obj.getClass().getAnnotation(TableName.class).name())
                .append("(");

        StringBuffer cols = new StringBuffer();
        StringBuffer values = new StringBuffer().append("(");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object o = field.get(obj);
            name = DataConversionUtil.underline(name);
            if (StringUtils.isEmpty(o)) {
                continue;
            }
            if (field.getType() == String.class) {
                //String类别
                cols.append(" ").append(name).append(",");
                values.append(" ").append("'").append(o).append("'").append(",");
            } else {
                //驼峰转下划线
                cols.append(" ").append(name).append(",");
                values.append(" ").append(o).append(",");
            }

        }
        cols.deleteCharAt(cols.length() - 1);
        values.deleteCharAt(values.length() - 1);
        cols.append(")");
        values.append(")");
        sql.append(cols).append("VALUE").append(values);
        return sql.toString();
    }

    /**
     * @param obj
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 4:14 下午 2020/3/26
     */
    public String generateDeleteByIdSql(T obj) throws IllegalAccessException {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from ")
                .append(obj.getClass().getAnnotation(TableName.class).name())
                .append(" where ");
        StringBuffer column = new StringBuffer(), value = new StringBuffer();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Id.class)) {
                Object o = field.get(obj);
                column.append(DataConversionUtil.underline(field.getName()));
                if (field.getType() == String.class) {
                    //String类别
                    value.append("'").append(o).append("'");
                } else {
                    value.append(o);
                }
            }
        }
        sql.append(column).append(" = ").append(value);
        return sql.toString();
    }

    /**
     * 更新所有字段(待测)
     *
     * @param obj
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 4:14 下午 2020/3/26
     */
    public String generateUpdateAllFiledByIdSql(T obj) throws IllegalAccessException {
        StringBuffer sql = new StringBuffer();
        sql.append("update")
                .append(obj.getClass().getAnnotation(TableName.class).name())
                .append(" set ");
        StringBuffer column = new StringBuffer(), where = new StringBuffer(" where ");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fileName = DataConversionUtil.underline(field.getName());
            Object o = field.get(obj);
            if (field.isAnnotationPresent(Id.class)) {
                where.append(fileName).append(" = ");
                if (field.getType() == String.class) {
                    //String类别
                    where.append("'").append(o).append("'");
                } else if (field.getType() == Date.class) {
                    throw new IllegalAccessException("请不要使用Date类型，换用LocalDate或LocalDateTime。");
                } else {
                    where.append(o);
                }
            } else {
                if (o == null) {
                    column.append(fileName).append(" = ").append(o);
                }
                if (field.getType() == String.class) {
                    //String类别
                    column.append(fileName).append(" = ").append("'").append(o).append("'");
                } else if (field.getType() == Date.class) {
                    throw new IllegalAccessException("请不要使用Date类型，换用LocalDate或LocalDateTime。");
                } else {
                    column.append(o);
                }
                column.append(",");
            }
        }
        //去除最后一个逗号
        column.deleteCharAt(column.length() - 1);
        sql.append(column);
        sql.append(where);
        return sql.toString();
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
    public String generateUpdateNotNullFiledByIdSql(T obj) throws IllegalAccessException {
        StringBuffer sql = new StringBuffer();
        sql.append("update ")
                .append(obj.getClass().getAnnotation(TableName.class).name())
                .append(" set ");
        StringBuffer column = new StringBuffer(), where = new StringBuffer(" where ");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fileName = DataConversionUtil.underline(field.getName());
            Object o = field.get(obj);
            if (o == null) {
                continue;
            }
            if (field.isAnnotationPresent(Id.class)) {
                where.append(fileName).append(" = ");
                if (field.getType() == String.class) {
                    //String类别
                    where.append("'").append(o).append("'");
                } else if (field.getType() == Date.class) {
                    throw new IllegalAccessException("请不要使用Date类型，换用LocalDate或LocalDateTime。");
                } else {
                    where.append(o);
                }
            } else {
                if (field.getType() == String.class) {
                    //String类别
                    column.append(fileName).append(" = ").append("'").append(o).append("'");
                } else if (field.getType() == Date.class) {
                    throw new IllegalAccessException("请不要使用Date类型，换用LocalDate或LocalDateTime。");
                } else {
                    column.append(fileName).append(" = ").append(o);
                }
                column.append(",");
            }
        }
        //去除最后一个逗号
        column.deleteCharAt(column.length() - 1);
        sql.append(column);
        sql.append(where);
        return sql.toString();
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
    public String generateDeleteByIdListSql(Class clazz, List<Integer> list) throws IllegalAccessException {
        if (CollUtil.isEmpty(list)) {
            throw new IllegalAccessException("ids不允许为空");
        }
        StringBuffer sql = new StringBuffer();
        Annotation annotation = clazz.getAnnotation(TableName.class);
        TableName tableName = (TableName) annotation;
        // 获取强 转之后类上的方法名字
        LogicDelete logicDelete = (LogicDelete) clazz.getAnnotation(LogicDelete.class);
        sql.append("UPDATE ").append(tableName.name()).append(" SET deleted = ").append(logicDelete.deleted()).append(" where ");
        StringBuffer column = new StringBuffer(), value = new StringBuffer();
        List<Field> fields = getAllFiled(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Id.class)) {
                column.append(DataConversionUtil.underline(field.getName())).append(" in (");
            }
        }
        for (long l : list) {
            column.append(l).append(",");
        }
        column.deleteCharAt(column.length() - 1);
        column.append(")");
        sql.append(column);
        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 启用,使用
     *
     * @param clazz
     * @param id
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 9:51 上午 2020/12/17
     */
    public String generateOpenById(Class clazz, Object id) {
        StringBuffer sql = new StringBuffer();
        TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
        sql.append("update ").append(tableName).append(" ");
        State state = (State) clazz.getAnnotation(State.class);
        StringBuffer set = new StringBuffer(" set ");
        StringBuffer where = new StringBuffer(" where ");

        List<Field> fields = getAllFiled(clazz);
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(State.class)) {
                set.append(DataConversionUtil.underline(field.getName())).append(" = ").append(state.openValue()).append(" ");
            }
            if (field.isAnnotationPresent(Id.class)) {
                where.append(DataConversionUtil.underline(field.getName())).append(" = ").append(id).append(" ");
            }
        }
        sql.append(set).append(where);
        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 禁用
     *
     * @param clazz
     * @param id
     * @return java.lang.String
     * @author ZhangJie
     * @description
     * @date 9:51 上午 2020/12/17
     */
    public String generateCloseById(Class clazz, Object id) {
        StringBuffer sql = new StringBuffer();
        TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
        sql.append("update ").append(tableName).append(" ");
        State state = (State) clazz.getAnnotation(State.class);
        StringBuffer set = new StringBuffer(" set ");
        StringBuffer where = new StringBuffer(" where ");
        List<Field> fields = getAllFiled(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(State.class)) {
                set.append(DataConversionUtil.underline(field.getName())).append(" = ").append(state.closeValue()).append(" ");
            }
            if (field.isAnnotationPresent(Id.class)) {
                where.append(DataConversionUtil.underline(field.getName())).append(" = ").append(id).append(" ");
            }
        }
        sql.append(set).append(where);
        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 通过类获取所有的字段
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
