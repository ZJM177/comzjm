package myspring.threadPool.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * @author zhujiameng
 * @create 2018-06-08 14:05
 **/
public class Worker implements Runnable {
    protected Queue<Object> workQueue;
    protected Map<String,Object> resultMap;

  /*  public Worker(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }*/

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true){
            Object poll = workQueue.poll();
            if(poll==null) break;
            Object o=handle(poll);
            resultMap.put(Integer.toString(poll.hashCode()),o);
        }
    }

    public Object handle(Object poll) {
        return poll;
    }
}
