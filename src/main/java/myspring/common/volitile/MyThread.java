package myspring.common.volitile;

/**
 * @author zhujiameng
 * @create 2018-07-18 16:08
 **/
public class MyThread extends Thread {

    private  volatile boolean stop=false;
    public void stopMe(){
        stop=true;
    }
    @Override
    public void run() {
        int i=0;
        while (!stop){
            i++;
        }
        System.out.println("stop xx");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.stopMe();
    }
}
