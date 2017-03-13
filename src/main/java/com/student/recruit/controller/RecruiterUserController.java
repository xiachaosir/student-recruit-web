package com.student.recruit.controller;

import com.student.recruit.dto.RecruiterUserExceptPwd;
import com.student.recruit.service.RecruiterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by xiachao on 2017/3/13.
 */
@RestController
public class RecruiterUserController {

  @Autowired
  private RecruiterUserService recruiterUserService;


  @GetMapping("/recruiter/users/{id}")
  public ResponseEntity<RecruiterUserExceptPwd> getUser(@PathVariable UUID id) {
    if (id != null) {
      RecruiterUserExceptPwd userExceptPwd = recruiterUserService.findUserById(id);
      return ResponseEntity.ok(userExceptPwd);
    }
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .cacheControl(CacheControl.noCache())
        .body(null);
  }


}
