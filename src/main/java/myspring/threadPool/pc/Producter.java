package myspring.threadPool.pc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhujiameng
 * @create 2018-06-28 9:32
 **/
public class Producter implements Runnable {

    private volatile boolean isRuning=true;
    private BlockingQueue<PCData> queue;

    private static AtomicInteger count=new AtomicInteger();

    private static final int SLEEPTIME=1000;

    public Producter(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData pcData=null;
        Random random = new Random();
        System.out.println("当前线程ID:"+Thread.currentThread().getId());

            try {
                while (isRuning){
                Thread.sleep(random.nextInt(SLEEPTIME));
                pcData=new PCData(count.incrementAndGet());
                System.out.println(pcData+"is put into quene");
                if(!queue.offer(pcData,2, TimeUnit.SECONDS)){
                    System.out.println("failed to put data"+pcData);
                }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

    }

    public void stop(){
        isRuning=false;
    }
}
