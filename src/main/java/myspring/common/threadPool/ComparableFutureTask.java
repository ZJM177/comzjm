package myspring.common.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhujiameng
 * @create 2018-07-05 13:50
 **/
public class ComparableFutureTask <V>
        extends FutureTask<V> implements Comparable<ComparableFutureTask<V>>  {
    private Object object;

    public ComparableFutureTask(Callable<V> callable) {
        super(callable);
        object=callable;
    }

    public ComparableFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        object=runnable;
    }


    @Override
    public int compareTo(ComparableFutureTask<V> o) {
        if (this == o) {
            return 0;
        }
        if (o == null) {
            return -1; // high priority
        }
        if (object != null && o.object != null) {
            if (object.getClass().equals(o.object.getClass())) {
                if (object instanceof Comparable) {
                    return ((Comparable) object).compareTo(o.object);
                }
            }
        }
        return 0;
    }
}
