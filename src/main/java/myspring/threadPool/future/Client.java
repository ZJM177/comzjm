package myspring.threadPool.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author zhujiameng
 * @create 2018-06-07 9:48
 **/
public class Client {
/*    public Data request(final String str){
        final FutureData future=new FutureData();
        new Thread(){
            @Override
            public void run() {
                RealData realData=new RealData(str);
                future.setRealData(realData);
                System.out.println("当前线程："+Thread.currentThread().getName());
            }
        }.start();

        return future;
    }
    */
    public static void main(String [] a) throws ExecutionException, InterruptedException {
/*        Client client = new Client();
        Data da  = client.request("张三");
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        System.out.println(da.getResult());*/

        FutureTask<String> future=new FutureTask<String>(new RealData("aaa"));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(future);
        System.out.println(future.get());

    }
}
