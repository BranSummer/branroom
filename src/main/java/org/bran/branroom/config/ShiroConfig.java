package org.bran.branroom.config;


import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;


@Configuration
public class ShiroConfig {

    @Bean
    @Description("生命周期处理器,保证实现了Shiro内部lifecycle函数的bean执行")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @Description("缓存管理器")
    public MemoryConstrainedCacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }
    @Bean
    @Description("Servlet容器会话管理器")
    public ServletContainerSessionManager servletContainerSessionManager(){
        return new ServletContainerSessionManager();
    }

    

}
