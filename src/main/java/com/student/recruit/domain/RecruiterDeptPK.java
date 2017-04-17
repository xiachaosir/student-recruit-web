package com.student.recruit.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * 部门复合主键.
 * Created by xiachao on 2017/4/13.
 */
@Embeddable
public class RecruiterDeptPK implements Serializable {

  @Column(name = "dept_id", nullable = false)
  private String deptId;

  @Column(name = "rec_id", nullable = false)
  private UUID recId;

  public RecruiterDeptPK() {
  }

  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public UUID getRecId() {
    return recId;
  }

  public void setRecId(UUID recId) {
    this.recId = recId;
  }
}
