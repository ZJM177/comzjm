package myspring.common.threadPool;

import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujiameng
 * @create 2018-07-05 12:42
 **/
public class ExecutorServiceTests {
    public static void main(String[] args){
        XThreadPoolExecutor threadPoolExecutor = new XThreadPoolExecutor(100, 200, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>(200));
        for (int i=0;i<=2147483647;i++){
            Future<?> submit = threadPoolExecutor.submit(new MyThread(":_" + i));
            System.out.println("ActiveCount ：" +threadPoolExecutor.getActiveCount());
            System.out.println("TaskCount ：" +threadPoolExecutor.getTaskCount());
            System.out.println("CompletedTaskCount ：" +threadPoolExecutor.getCompletedTaskCount());
            System.out.println("quene size ：" +threadPoolExecutor.getQueue().size()+"容量："+threadPoolExecutor.getQueue().remainingCapacity());


        }
    }
}
