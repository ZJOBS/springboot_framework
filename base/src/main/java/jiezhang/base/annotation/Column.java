package jiezhang.base.annotation;

import java.lang.annotation.*;

/**
 * 字段
 *
 * @author ZhangJie
 * @description
 * @date 3:03 下午 2020/3/26
 * @return
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    String name() default "";
}
