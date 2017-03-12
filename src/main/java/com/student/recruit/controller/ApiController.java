package com.student.recruit.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiachao on 2017/3/9.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

  @RequestMapping("/index")
  @ApiOperation(value = "测试api", notes = "")
  public String index() {
    return "success";
  }
}
