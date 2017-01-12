package com.student.recruit.controller;

import com.student.recruit.domain.User;
import com.student.recruit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/12 18:00
 */
@Controller
public class RegisterController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("register")
  public String register(){
    return "register";
  }

  @PostMapping("register")
  public String register(@Validated User user ){
    userRepository.save(user);
    return "index";
  }
}
