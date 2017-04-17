package com.student.recruit.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description 公司部门实体类.
 * @Author xiachao
 * @CreateTime 2017/2/9 14:02
 */

@Entity
@Table(name = "tb_rec_dept_new")
public class RecruiterDept implements Serializable {
  private static final long serialVersionUID = 324189933206420691L;
  //部门id和公司id作为复合主键
  @EmbeddedId
  private RecruiterDeptPK recruiterDeptPK;

  //部门名称
  @Column(length = 100, nullable = false)
  private String name;
  //流程创建时间
  @CreationTimestamp
  @JsonFormat(pattern = "yyyyMMddHHmmss")
  private LocalDateTime createdOn;
  //流程修改时间
  @UpdateTimestamp
  @JsonFormat(pattern = "yyyyMMddHHmmss")
  private LocalDateTime updatedOn;

  /**
   * .
   */
  public RecruiterDept() {
  }

  public RecruiterDeptPK getRecruiterDeptPK() {
    return recruiterDeptPK;
  }

  public void setRecruiterDeptPK(RecruiterDeptPK recruiterDeptPK) {
    this.recruiterDeptPK = recruiterDeptPK;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
