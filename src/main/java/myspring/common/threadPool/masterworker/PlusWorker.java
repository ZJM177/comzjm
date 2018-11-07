package myspring.common.threadPool.masterworker;

/**
 * @author zhujiameng
 * @create 2018-06-08 14:21
 **/
public class PlusWorker extends  Worker {
    public Object handle(Object poll) {
        Integer poll1 = (Integer) poll;
        return poll1*poll1*poll1;
    }
}
