package com.student.recruit;

import com.student.recruit.realm.UserRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/11 14:30
 */
@Configuration
public class ShiroConfig {
  @Bean(name = "securityManager")
  public DefaultWebSecurityManager defaultWebSecurityManager() {
    DefaultWebSecurityManager dsm = new DefaultWebSecurityManager();
    List<Realm> realms = new ArrayList<>();
    realms.add(userRealm());
    dsm.setRealms(realms);
    return dsm;
  }

  @Bean(name = "shiroFilterFactoryBean")
  public ShiroFilterFactoryBean shiroFilterFactoryBean() {
    ShiroFilterFactoryBean sf = new ShiroFilterFactoryBean();
    sf.setSecurityManager(defaultWebSecurityManager());
    sf.setSuccessUrl("/index");
    sf.setLoginUrl("/login");
    //sf.setUnauthorizedUrl("/login");
    Map<String, Filter> filters = new HashMap<>();
    sf.setFilters(filters);
    Map<String, String> urls = new LinkedHashMap<String, String>() {
      {
        put("/login", "anon");
        put("/img/**", "anon");
        put("/css/**", "anon");
        put("/js/**", "anon");
        put("/**", "anon");
      }
    };
    sf.setFilterChainDefinitionMap(urls);
    return sf;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
    AuthorizationAttributeSourceAdvisor auth = new AuthorizationAttributeSourceAdvisor();
    auth.setSecurityManager(defaultWebSecurityManager());
    return auth;
  }

  @Bean
  public Realm userRealm() {
    return new UserRealm();
  }

}
