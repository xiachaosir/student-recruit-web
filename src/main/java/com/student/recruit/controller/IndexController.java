package com.student.recruit.controller;

import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/9 11:32
 */
@Controller
public class IndexController {

  @Autowired
  private UserService userService;

  /**
   * @Description test .
   * @Author xiachao
   * @CreateTime 2017/1/10 9:51
   * @Param
   * @Return
   */
  @RequestMapping("index")
  public String index(@RequestParam(value="username") String username, Model model) {
    model.addAttribute("username",username);
    return "index";
  }

}
