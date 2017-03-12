package com.student.recruit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接redis 方式 .
 * Created by xiachao on 2017/3/8.
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisJedisConfig {

  private Logger logger = LoggerFactory.getLogger(RedisJedisConfig.class);

  private String host;

  private int port;

  private String password;

  private int timeout;


  @Bean
  public JedisPoolConfig getRedisConfig() {
    JedisPoolConfig config = new JedisPoolConfig();
    return config;
  }

  @Bean
  public JedisPool getJedisPool() {
    JedisPoolConfig config = getRedisConfig();
    JedisPool pool = new JedisPool(config, host, port, timeout, password);
    logger.info("init JedisPool");
    return pool;
  }


  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getTimeout() {
    return timeout;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

   /*  redis configuration 使用RedisTemplate
   @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getJedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        logger.info("jedisConnectionFactory bean init success");
        return factory;
    }

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        RedisTemplate<?, ?> template = new StringRedisTemplate(getJedisConnectionFactory());
        return template;
    }*/
}
