package myspring.common;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhujiameng
 * @create 2018-07-31 10:13
 **/
public class countDownLatchDemo {
    public static void main(String[] args){
        final CountDownLatch countDownLatch  =new CountDownLatch(2){
            @Override
            public void await() throws InterruptedException {
                super.await();
            }
        };
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        },"th");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread2");


        thread1.start();
        thread2.start();


    }
}
