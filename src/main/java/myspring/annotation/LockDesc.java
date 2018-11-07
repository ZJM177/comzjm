package myspring.annotation;/**
 * Created by zjm on 2018/11/7.
 */

import java.lang.annotation.*;

/**
 * @author zhujiameng
 * @create 2018-11-07 15:37
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LockDesc {
    /**
     * 名称
     * @return
     */
    String name() default "global_lock";
}
