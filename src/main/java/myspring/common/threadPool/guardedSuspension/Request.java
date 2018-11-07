package myspring.common.threadPool.guardedSuspension;

/**
 * @author zhujiameng
 * @create 2018-06-25 9:39
 **/
public class Request {
    private String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
