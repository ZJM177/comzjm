package myspring.threadPool.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhujiameng
 * @create 2018-06-26 9:54
 **/
public class ForkJoinTaskTest {
    private static AtomicInteger seq = new AtomicInteger(0);
    private static Object lock = new Object();

    private static final class Sum extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 20;
        int start;
        int end;
      //  String name;
      //  int level;
        int id;
  /*      int parentId;
        String parentName;*/

 /*       public Sum(int id, Sum parent, String name, int start, int end, int level) {
            this.id = id;
            this.start = start;
            this.end = end;
        *//*    this.level = level;
            this.parentId = parent == null ? 0 : parent.id;
            this.parentName = parent == null ? "no Parent" : parent.name;
            this.name = parentId+"_"+name;*//*
        }*/

        public Sum(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        protected Integer compute() {
            int allsum=0;
            if ((end - start) < THRESHOLD) {
                int sum = getSum(id);
                System.out.println("return sum:" + this + ",sum" + sum);
                return sum;
            } else {
                int middle = (start + end) / 2;
                Sum left = new Sum(id,  start, middle);
                Sum right = new Sum(id,  middle + 1, end);
                left.fork();
                right.fork();
                allsum = left.join() + right.join();
                System.out.println("split end, allsum=" + allsum);
            }
            System.out.println("end compute:" + this);
            return allsum;
          /*  System.out.println("begin compute:" + this);
            int allsum = 0;
            if ((end - start) < THRESHOLD) {
                int sum = getSum(start, end);
                System.out.println("return sum:" + this + ",sum" + sum);
                return sum;
            } else {
                int middle = (start + end) / 2;
                Sum left = new Sum(seq.addAndGet(1), this, "left", start, middle, level + 1);
                Sum right = new Sum(seq.addAndGet(1), this, "right", middle + 1, end, level + 1);
                left.fork();
                right.fork();
                allsum = left.join() + right.join();
                System.out.println("split end, allsum=" + allsum);
            }
            System.out.println("end compute:" + this);
            return allsum;*/
        }

        private int getSum(int id) {
            int sum = 0;
            for (int i = 0; i <= id; i++) {
                sum += i;
            }
            return sum;
        }


        private int getSum(int start, int end) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(12);
        int id=1000000000;
        Sum sum= new Sum(id, 0, id);
        Future<Integer> result = forkJoinPool.submit(sum);
        System.out.println(result.get());
        System.out.println("耗时："+(System.currentTimeMillis()-start));*/
     /*   ForkJoinPool forkJoinPool = new ForkJoinPool();
        Sum sum= new Sum(seq.addAndGet(1), null, "base", 0, 100, 1);
        Future<Integer> result = forkJoinPool.submit(sum);
        System.out.println(result.get());*/
        long start=System.currentTimeMillis();
        int sum=0;
        for (int i = 0; i <= 1000000000; i++) {
            sum += i;
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start));
    }
}
