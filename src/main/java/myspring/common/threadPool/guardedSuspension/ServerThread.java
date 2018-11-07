package myspring.common.threadPool.guardedSuspension;

/**
 * @author zhujiameng
 * @create 2018-06-25 10:06
 **/
public class ServerThread extends Thread{

    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue,String name){
        super(name);
        this.requestQueue=requestQueue;
    }
    public void run(){
        while (true){
            final Request request = this.requestQueue.getRequest();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" =="+request);
        }
    }
}
