package com.hhz.shiro.config;

import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Author Rem
 * @Date 2020-08-09
 */


@Configuration
public class ShiroConfig {


    /**
     * shiro校验的数据来源
     *
     * @return
     */
    @Bean
    public IniRealm getInIrealm() {
        //shior和数据之间的校验桥梁 realm
        IniRealm realm = new IniRealm("classpath:shior.ini");
        return realm;
    }

    /**
     * shior核心组件 安全管理器===>相当于sprngmvc的  DispatcherServlet
     *
     * @param iniRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(IniRealm iniRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(iniRealm);
        return securityManager;
    }


    /**
     * shiro的核心过滤器
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(securityManager);


        //设置shiro的拦截规则
        //anon  匿名用户可访问
        //authc 认证用户可访问
        //user  使用RememberMe的用户可访问
        //perms 对应权限可访问
        //role  对应的角色课访问

        HashMap<String, String> filterMap = new HashMap<>();
        filterMap.put("/", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/regist.html", "anon");
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/regist", "anon");
        filterMap.put("/static/**", "anon");
        filterMap.put("/**", "authc");
        filter.setFilterChainDefinitionMap(filterMap);

        return filter;
    }
}
