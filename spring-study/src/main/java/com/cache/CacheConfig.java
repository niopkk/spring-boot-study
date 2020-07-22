package com.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching  //启用spring 缓存
public class CacheConfig {

    /**
     * ConcurrentMapCacheManager 缓存管理器
     *
     * @return
     */
//    @Bean
//    public CacheManager cacheManager() {
//        //申明缓存管理器
//        return new ConcurrentMapCacheManager();
//    }
//    @Bean
//    public EhCacheCacheManager cacheCacheManager() {
//        return new EhCacheCacheManager(ehcache().getObject());
//    }
    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(""));//配置ehcacheCache配置文件地址
        return ehCacheManagerFactoryBean;
    }


//    @Cacheable：spring在方法调用前，首先在缓存中查找方法的返回值，如果找到返回值，就返回缓存的值，否则这个方法就会被调用，
//                 返回值会放到缓存中。
//    @CachePut:sping 会将方法的返回值放到缓存中，方法调用前并不会检查缓存，方法始终都会被调用。


//    @CacheEvict:表明sping在缓存中清除一个或者多个条目。

//    @Caching:这个是分组注解，能够同时应用多个其他缓存注解。


}
