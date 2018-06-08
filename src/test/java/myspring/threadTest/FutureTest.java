package myspring.threadTest;

import java.util.concurrent.*;

/**
 * 异步测试
 *
 * @author zhujiameng
 * @create 2018-06-08 9:18
 **/
public class FutureTest{
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        Future<Integer> submit1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return method1() + method2();
            }

        });

        Future<Integer> submit2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return method3() ;
            }

        });


        Future<Integer> submit3 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return method4() ;
            }

        });

        Integer result=submit1.get()+submit2.get()+submit3.get();
        long end = System.currentTimeMillis();
        System.out.println("耗时时间："+(end-start));
    }

    private static Integer method4() {
        delay200ms();
        return 4;
    }

    private static Integer method3() {
        delay200ms();
        return 3;
    }

    private static int method2() {
        delay200ms();
        return 2;
    }

    private static int method1() {
        delay200ms();
        return 1;
    }

    private static void delay200ms() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
