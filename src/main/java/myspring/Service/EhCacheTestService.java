package myspring.Service;/**
 * Created by zjm on 2018/6/1.
 */

/**
 * 测试缓存
 *
 * @author zhujiameng
 * @create 2018-06-01 14:06
 **/
public interface EhCacheTestService {
    public String getTimestamp(String param);

    public String saveTimestamp(String param);
}
