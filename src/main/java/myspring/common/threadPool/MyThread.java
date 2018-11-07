package myspring.common.threadPool;

/**
 * @author zhujiameng
 * @create 2018-07-04 13:33
 **/
public class MyThread implements Runnable,Comparable<MyThread> {
    protected String name;

    public MyThread() {
    }

    public String getName() {
        return name;
    }

    public MyThread(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(MyThread o) {
        int i = Integer.parseInt(this.name.split("_")[1]);
        int i1 = Integer.parseInt(o.getName().split("_")[1]);
        if(i>i1){return  1;}
        else if(i<i1){return -1;}
        else
        return 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(name+"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
