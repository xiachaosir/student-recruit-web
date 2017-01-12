package com.student.recruit.controller;

import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/9 11:32
 */
@Controller
public class IndexController  {

  @Autowired
  private UserService userService;
  
  /**
   * @Description  test .
   * @Author  xiachao
   * @CreateTime 2017/1/10 9:51
   * @Param  
   * @Return 
   */
  @RequestMapping("index")
  public String index(){
    return "index";
  }

}
