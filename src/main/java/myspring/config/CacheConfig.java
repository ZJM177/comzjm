package myspring.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 缓存配置
 *
 * @author zhujiameng
 * @create 2018-06-01 10:18
 **/
@Configuration
@EnableCaching
public class CacheConfig {
    /**
     * 配置的是ehcache缓存
     * @param cm
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(CacheManager cm){
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean=new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
       // ehCacheManagerFactoryBean.afterPropertiesSet();
        return ehCacheManagerFactoryBean;
    }


}
