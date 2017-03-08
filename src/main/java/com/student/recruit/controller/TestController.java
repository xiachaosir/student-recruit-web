package com.student.recruit.controller;

import com.student.recruit.domain.AuthorSetting;
import com.student.recruit.domain.User;
import com.student.recruit.repository.UserRepository;
import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by xiachao on 2017/3/6.
 */
@RestController
@RequestMapping("/api")
public class TestController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorSetting authorSetting;

    @RequestMapping("/test")
    public String test() {
        return "Hello world";
    }

    @RequestMapping("/author")
    public String author() {
        return authorSetting.getName() + authorSetting.getAge() + "";
    }

    @RequestMapping("/deletecount")
    @Transactional
    public void userCount() {
        Long count = userRepository.deleteByPhone("123");
        System.out.println(count);
    }

    @RequestMapping("/savecache")
    public String cache() {
        User user = new User();
        user.setUsername("夕阳在美不如你");
        user.setRealName("夏超");
        user.setEmail("401602421@qq.com");
        user.setPhone("17600208928");
        userService.save(user);
        String userId = user.getId();
        return userId;
    }

    @RequestMapping("/findcache")
    public String findcache(String id) {
        User user = userService.findById(id);
        System.out.println(user.getId());
        return user.getRealName();
    }

    @RequestMapping("/findphone")
    public String findPhone(String phone) {
        try {
            User user = userService.findByPhone(phone);
            System.out.println(user.getId());
            return user.getRealName();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误了");
    }
}
