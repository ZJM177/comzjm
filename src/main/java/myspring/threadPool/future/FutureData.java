package myspring.threadPool.future;

/**
 * future
 *FutureData 是realData的包装
 * @author zhujiameng
 * @create 2018-06-07 9:33
 **/
/*
public class FutureData implements Data {

    protected  RealData realData=null;
    protected boolean isReady=false;

    public synchronized void setRealData(RealData data){
        if(isReady){
            return ;
        }
        realData=data;
        isReady=true;
        notifyAll();
    }
    @Override
    public synchronized String getResult() {
        while (!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        return realData.getResult();
    }
}
*/
