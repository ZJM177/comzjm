package myspring.common.threadPool.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author zhujiameng
 * @create 2018-06-26 9:19
 **/
public class SqrtTransform extends RecursiveAction {
    final int seqThreshold = 10000;
    double[] data;
    int start,end;
    public SqrtTransform(double[] vals,int s,int e){
        data = vals;
        start = s;
        end = e;
    }

    @Override
    protected void compute() {
        if((end - start) < seqThreshold ){
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        }else{
            int middle = (start + end ) / 2;
            invokeAll(new SqrtTransform(data,start,middle),new SqrtTransform(data,middle,end));
        }
    }
}
