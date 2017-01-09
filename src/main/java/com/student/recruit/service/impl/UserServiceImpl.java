package com.student.recruit.service.impl;

import com.student.recruit.domain.User;
import com.student.recruit.repository.UserRepository;
import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description  .
 * @Author  xiachao
 * @CreateTime 2017/1/9 11:32
 */
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  /**
   * @param user
   */
  @Override
  public void delete(User user) {
    userRepository.delete(user);
  }

  /**
   * @param user
   */
  @Override
  public void update(User user) {
      userRepository.save(user);
  }

  /**
   * @param user
   */
  @Override
  public void save(User user) {
     userRepository.save(user);
  }
}
