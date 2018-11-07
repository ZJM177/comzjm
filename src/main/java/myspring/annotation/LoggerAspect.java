package myspring.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zhujiameng
 * @create 2018-11-02 14:16
 **/

@Aspect
public class LoggerAspect {
    //定义切入点
    @Pointcut(value="execution(* myspring.Service..*.*(..)) && args(param)", argNames = "param")
    public void beforePointcut(String param) {}


    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param) {

        System.out.println("===========before advice param:" + param


        );
    }

}
