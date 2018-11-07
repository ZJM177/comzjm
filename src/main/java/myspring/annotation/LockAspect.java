package myspring.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;

/**
 * @author zhujiameng
 * @create 2018-11-07 15:44
 **/
@Aspect
@Component
@Scope("prototype")
public class LockAspect {
    @Autowired
    private Map<String, Lock> lockMap;

    @Before(value = "@annotation(lockDesc)")
    public void beforeInit(LockDesc lockDesc){
        Lock lock = lockMap.get(lockDesc.name());
        Optional.ofNullable(lock).ifPresent(l->{
            l.lock();
            System.err.println(Thread.currentThread().getName() + "：占用锁-"+lockDesc.name());
        });

    }

    /**
     * 自动释放锁
     * @param
     */
    @After(value = "@annotation(lock)")
    public void afterReleaseLock(LockDesc lock) {
        // 获取锁
        Lock currentLock = lockMap.get(lock.name());
        Optional.ofNullable(currentLock).ifPresent(l -> {
            l.unlock();
            System.err.println(Thread.currentThread().getName() + "：释放锁-"+lock.name());
        });
    }
}
