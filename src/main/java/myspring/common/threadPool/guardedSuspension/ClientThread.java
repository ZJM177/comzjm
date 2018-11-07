package myspring.common.threadPool.guardedSuspension;

/**
 * @author zhujiameng
 * @create 2018-06-25 14:43
 **/
public class ClientThread extends Thread {

    private RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue,String name){
        super(name);
        this.requestQueue=requestQueue;
    }

    public void run(){
        for (int i=0;i<10;i++){
            Request request = new Request("RequrstID:" + i + " Thread_name:" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+" requests "+request);
            requestQueue.addRequest(request);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is "+Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName()+" request end ");
    }

    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        for (int i=0;i<10;i++){
            new ServerThread(requestQueue,"serverThread"+i).start();
        }

        for (int i=0;i<10;i++){
            new ClientThread(requestQueue,"ClientThread"+i).start();
        }
    }
}
