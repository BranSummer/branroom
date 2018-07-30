package org.bran.branroom.config;


import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.bran.branroom.security.CustomRealm;
import org.bran.branroom.security.RetryLimitHashedCredentialsMatcher;
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

    @Bean
    @Description("凭证匹配器")
    public RetryLimitHashedCredentialsMatcher credentialsMatcher(){
        RetryLimitHashedCredentialsMatcher credentialsMatcher= new RetryLimitHashedCredentialsMatcher();
        //指定散列算法为md5
        credentialsMatcher.setHashAlgorithmName("md5");
        //散列迭代次数
        credentialsMatcher.setHashIterations(2);
        //表示是否存储散列后的密码为16进制
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    @Bean
    @Description("这是个自定义的认证类，继承自AuthorizingRealm， 负责用户的认证和权限的处理")
    public CustomRealm customRealm(RetryLimitHashedCredentialsMatcher matcher){
        CustomRealm customRealm =new CustomRealm();
        //凭证匹配器
        customRealm.setCredentialsMatcher(matcher);
        //是否缓存
        customRealm.setCachingEnabled(true);

        return  customRealm;
    }

    @Bean
    public SecurityManager securityManager(CustomRealm customRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        return securityManager;
    }
    

}
