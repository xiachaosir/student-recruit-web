package com.student.recruit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description  .
 * @Author  xiachao
 * @CreateTime 2017/1/9 11:32
 */
@Entity
@Table(name = "s_user")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private String id;

  @Column(nullable = false)
  private String username;

  @Column
  private String password;

  @Column
  private String email;

  @Column
  private String phone;




}
