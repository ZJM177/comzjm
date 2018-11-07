package myspring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhujiameng
 * @create 2018-11-02 13:58
 **/
@Aspect
@Component
public class AnnotationAspect {
    @Pointcut("within(myspring.controller..*) ")
    public void performance() {

    }


    @Around(value = "@annotation(test)")
    public int before(ProceedingJoinPoint joinPoint, Test test) throws Throwable{
      Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        Class<?> clazz = target.getClass();
        Method method = clazz.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        String className = clazz.getName().substring( clazz.getName().lastIndexOf(".")+1);
        System.out.println(":::==="+"--"+test.message());
        return 0;
    }
}
