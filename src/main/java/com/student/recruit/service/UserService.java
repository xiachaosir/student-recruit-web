package com.student.recruit.service;

import com.student.recruit.domain.User;

import java.util.List;

/**
 * @Description .
 * @Author xiachao
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

    User findByPhone(String id);

    User findById(String id);

    /**
     * 查找所有用户
     *
     * @return list
     */
    List<User> findAll();
}
