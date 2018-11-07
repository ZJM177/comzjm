package myspring.annotation;

import java.lang.annotation.*;

/**
 * @author zhujiameng
 * @create 2018-11-02 11:34
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Test {
    String value() default "未定义";
    String message() default "";
}
