package com.student.recruit.service;

import com.student.recruit.domain.User;

/**
 * @Description  .
 * @Author  xiachao
 * @CreateTime 2017/1/9 11:32
 */

public interface UserService {

  /**
   *
   */
  public void delete(User user);

  /**
   *
   */
  public void update(User user);

  /**
   *
   */
  public void save(User user);
}
