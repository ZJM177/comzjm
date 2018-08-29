package myspring.threadPool.pc;

import myspring.threadPool.forkjoin.SqrtTransform;

import java.util.concurrent.ForkJoinPool;

/**
 * @author zhujiameng
 * @create 2018-06-25 15:48
 **/
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
