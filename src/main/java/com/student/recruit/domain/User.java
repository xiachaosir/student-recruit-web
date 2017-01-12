package com.student.recruit.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/9 11:32
 */
@Entity
@Table(name = "s_user", schema = "public")
public class User implements Serializable {

  private static final long serialVersionUID = 5872570319129514618L;

  @Id
  @GenericGenerator(name = "idGenerator", strategy = "uuid") //策略通用生成器
  @GeneratedValue(generator = "idGenerator") //使用uuid的生成策略
  @Column(name="id",length = 255,nullable = true)
  private String id;

  @Column(name = "user_name", length = 30)
  private String username;

  @Column(name = "password", length = 30)
  private String password;

  @Column(name = "real_name", length = 30)
  private String realName;

  @Column(name = "email", length = 30)
  private String email;

  @Column(name = "phone", length = 15)
  private String phone;

  @Column(name = "create_date", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;

  @Column(name = "update_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;

  /**
   * 无参构造方法.
   */
  public User() {
  }

  /**
   * 有参构造方法.
   */
  public User(String id, String username, String password, String realName, String email,
              String phone, Date createDate, Date updateDate) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.realName = realName;
    this.email = email;
    this.phone = phone;
    this.createDate = createDate;
    this.updateDate = updateDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
}
