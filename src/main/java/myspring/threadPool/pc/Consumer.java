package myspring.threadPool.pc;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhujiameng
 * @create 2018-06-28 10:15
 **/
public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME=1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start consumer thread id:"+Thread.currentThread().getId());
        Random random = new Random();
        try {
            while (true){
                PCData take = queue.take();
                if(null!=take){
                    int i = take.getIntData() * take.getIntData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}",take.getIntData(),take.getIntData(),i));
                    Thread.sleep(random.nextInt(SLEEPTIME));

                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("thread id:"+Thread.currentThread().getId());
            Thread.currentThread().interrupt();
        }
    }
}
