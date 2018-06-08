package myspring.Service.impl;

import myspring.Service.EhCacheTestService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 实现
 *
 * @author zhujiameng
 * @create 2018-06-01 14:06
 **/
@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {
    @Cacheable(value = "cacheTest", key = "#param", unless ="#param.equals('p')",condition = "!#param.contains('param')")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        byte[] bytes = new byte[1024*1024];
        System.out.println("方法内："+param.substring(param.lastIndexOf("m")));
        return timestamp.toString();
    }

    @Override
    @CachePut(value = "cacheTest", key = "#param")
    public String saveTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        System.out.println("方法内："+param.substring(param.lastIndexOf("m")));
        return param;
    }
}
