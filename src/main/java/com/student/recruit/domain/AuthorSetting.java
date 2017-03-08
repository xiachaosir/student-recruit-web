package com.student.recruit.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基于类型安全的常量.
 * Created by xiachao on 2017/3/7.
 */

@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSetting {

    private String name;

    private Integer age;

    public AuthorSetting() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
