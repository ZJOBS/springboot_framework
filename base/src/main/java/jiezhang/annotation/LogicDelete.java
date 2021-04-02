package jiezhang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识逻辑删除字段
 *
 * @author ZhangJie
 * @description ID
 * @date 9:40 下午 2020/3/5
 * @return
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface LogicDelete {
    /**
     * 已删除
     *
     * @author ZhangJie
     * @date 2:31 下午 2020/12/14
     */
    String deleted() default "1";

    /**
     * 未删除
     *
     * @author ZhangJie
     * @date 2:31 下午 2020/12/14
     */
    String unDelete() default "0";
}
