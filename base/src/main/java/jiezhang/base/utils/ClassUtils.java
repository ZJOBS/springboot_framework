package jiezhang.base.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类工具
 */
public class ClassUtils {
    /**
     * 获取类所有字段，包含父类
     *
     * @param clazz
     * @return
     */
    public static List<Field> getAllFiled(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }

    /**
     * 获取对象所有字段，包含父类
     *
     * @param obj
     * @return
     */
    public static List<Field> getAllFiled(Object obj) {
        Class clazz = obj.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }
}
