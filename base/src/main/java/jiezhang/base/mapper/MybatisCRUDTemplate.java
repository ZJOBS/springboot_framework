package jiezhang.base.mapper;

import cn.hutool.core.util.StrUtil;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import jiezhang.base.utils.DataConversionUtil;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

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
        Field[] fields = obj.getClass().getDeclaredFields();

        StringBuffer cols = new StringBuffer();
        StringBuffer values = new StringBuffer().append("(");
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

    public String deleteSql(T obj) {
        StringBuffer sql = new StringBuffer();
//        sql
//        delete FROM
//        <include refid="table_name"/>
//                where
//        dict_id = #{dictId}
        return sql.toString();
    }
}
