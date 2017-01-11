package com.student.recruit.controller;

import com.student.recruit.domain.User;
import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
   * @Description .
   * @Author xiachao
   * @CreateTime 2017/1/9 15:43
   * @Param
   * @Return
   */
  @PostMapping("/add")
  @ResponseBody
  public String addUser() {
    User user = new User();
    user.setUsername("xiachao");
    user.setPassword("1234");
    user.setRealName("夏超");
    user.setEmail("xiachaosir@163.com");
    user.setPhone("17600208928");
    user.setCreateDate(new Date());
    user.setUpdateDate(new Date());

    userService.save(user);

    return "success";
  }
  
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
