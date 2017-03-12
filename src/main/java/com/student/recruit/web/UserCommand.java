package com.student.recruit.web;

import com.student.recruit.domain.User;
import com.student.recruit.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * api测试类 .
 * Created by xiachao on 2017/3/9.
 */
@RestController
@RequestMapping("/users")
public class UserCommand {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping("/get")
    public List<User> getUserList() {
        List<User> userList = userService.findAll();
        return userList;
    }

    @ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体信息", required = true, dataType = "User")
    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userService.save(user);
        return "success";
    }
}
