package com.student.recruit.repository;

import com.student.recruit.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description  .
 * @Author  xiachao
 * @CreateTime 2017/1/9 11:32
 */
public interface UserRepository extends CrudRepository<User,String> {

  Page<User> findAll(Pageable pageable);

  User findById(String id);

  List<User> findByUserNameIgnoreCase(String username);



}
