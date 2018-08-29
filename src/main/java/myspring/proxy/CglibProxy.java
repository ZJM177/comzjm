package myspring.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDate;

/**
 * @author zhujiameng
 * @create 2018-08-06 14:24
 **/
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }
     @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println(LocalDate.now());
        return invoke;
    }


    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibProxy());
        enhancer.setSuperclass(CountServiceImpl.class);
        CountServiceImpl countService = (CountServiceImpl) enhancer.create();
        countService.count();
    }
}
