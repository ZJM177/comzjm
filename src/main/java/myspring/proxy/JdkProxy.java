package myspring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhujiameng
 * @create 2018-08-06 14:45
 **/
public class JdkProxy implements InvocationHandler {
    private  Object object;

    public JdkProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before:"+method.getName());
        Object o = method.invoke(object, args);
        System.out.println("aftre:"+method.getName());
        return o;
    }


    public static void main(String[] args){
        CountService service=new CountServiceImpl();
        InvocationHandler invocationHandler = new JdkProxy(service);
        CountService o = (CountService)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), service.getClass().getInterfaces(), invocationHandler);
        o.count();
   }
}
