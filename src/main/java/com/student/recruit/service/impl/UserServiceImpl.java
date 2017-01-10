package com.student.recruit.service.impl;

import com.student.recruit.domain.User;
import com.student.recruit.repository.UserRepository;
import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description  .
 * @Author  xiachao
 * @CreateTime 2017/1/9 11:32
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  /**
   * @param user
   */
  @Override
  @Transactional(readOnly = false)
  public void delete(User user) {
    userRepository.delete(user);
  }

  /**
   * @param user
   */
  @Override
  @Transactional(readOnly = false)
  public void update(User user) {
      userRepository.save(user);
  }

  /**
   * @param user
   */
  @Override
  @Transactional(readOnly = false)
  public void save(User user) {
     userRepository.save(user);
  }
}
