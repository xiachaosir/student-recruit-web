package com.student.recruit.dto;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 不包含密码的DTO.
 * Created by xiachao on 2017/3/12.
 */
public class RecruiterUserExceptPwd {


  private UUID id;

  //邮箱地址作为用户的登录账号
  private String email;

  //用户的真实姓名
  private String realName;

  //固定电话
  private String tel;

  //手机号
  private String mobile;

  //所属部门唯一Id
  private String deptId;

  //所属部门名称
  private String deptName;

  //账号状态(using:正常,disabled:已停用)
  private String status;

  //是否为管理员账号
  private boolean isAdmin;

  //用户创建时间
  private LocalDateTime createdOn;

  //用户修改时间
  private LocalDateTime updatedOn;

  /**
   *
   */
  public RecruiterUserExceptPwd() {
  }


  /**
   *
   *
   */
  public RecruiterUserExceptPwd(UUID id, String email, String realName, String tel, String mobile,
                                String deptId, String deptName, String status, boolean isAdmin,
                                LocalDateTime createdOn, LocalDateTime updatedOn) {
    this.id = id;
    this.email = email;
    this.realName = realName;
    this.tel = tel;
    this.mobile = mobile;
    this.deptId = deptId;
    this.deptName = deptName;
    this.status = status;
    this.isAdmin = isAdmin;
    this.createdOn = createdOn;
    this.updatedOn = updatedOn;
  }


  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public LocalDateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(LocalDateTime updatedOn) {
    this.updatedOn = updatedOn;
  }
}
