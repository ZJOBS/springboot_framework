package jiezhang.annotation;

import java.lang.annotation.*;

/**
 * 启用禁用状态
 *
 * @param
 * @author ZhangJie
 * @description
 * @date 9:33 上午 2020/12/17
 * @return
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface State {
    int openValue() default 1;

    int closeValue() default 0;
}
