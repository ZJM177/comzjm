/*
package myspring.lock;

*/
/**
 * @author zhujiameng
 * @create 2018-11-07 16:17
 **//*

*/
/**
 * redis 分布式锁实现
 *
 *//*

public class RedisLock implements Lock, AutoCloseable {

    private RedissonClient redisson;

    private String lockName;

    private RLock rLock;

    public RedisLock(Redisson redisson, String name) {
        this.rLock = redisson.getLock(name);
    }

    public RedisLock() {

    }

    @Override
    public void lock() {
        rLock.lock();
    }

    public Lock autoLock() {
        lock();
        return this;
    }

    public void lockInterruptibly() throws InterruptedException {
        rLock.lockInterruptibly();
    }

    public boolean tryLock() {
        return rLock.tryLock();
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return rLock.tryLock(time, unit);
    }

    public void unlock() {
        rLock.unlock();
    }

    public Condition newCondition() {
        return rLock.newCondition();
    }

    @Override
    public void close() throws Exception {
        unlock();
    }
}
*/
