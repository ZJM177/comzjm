package myspring.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhujiameng
 * @create 2018-06-08 15:41
 **/
public class SpringBeanManager implements ApplicationContextAware {

    private static ApplicationContext  applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public static Object getBean(String name){
        return  applicationContext.getBean(name);
    }
}
