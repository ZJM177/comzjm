package myspring.proxy;

/**
 * @author zhujiameng
 * @create 2018-06-20 16:37
 **/
public class CountServiceImpl implements CountService{

    private int count = 0;
    @Override
    public int count() {
        return count ++;
    }
}
