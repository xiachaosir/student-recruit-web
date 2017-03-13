package com.student.recruit.service;

import java.util.List;

/**
 * Created by xiachao on 2017/3/8.
 */
public interface RedisService {

  public boolean set(String key, String value);

  public String get(String key);

  public boolean expire(String key, long expire);

  public <T> boolean setList(String key, List<T> list);

  public <T> List<T> getList(String key, Class<T> clz);

  public long lpush(String key, Object object);

  public long rpush(String key, Object object);

  public String lpop(String key);
}
