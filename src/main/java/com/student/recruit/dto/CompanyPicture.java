package com.student.recruit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Description 公司图片类.
 * @Author xiachao
 * @CreateTime 2017/2/22 12:53
 */

public class CompanyPicture implements Serializable {

  private static final long serialVersionUID = 475762096136241217L;

  //公司图片唯一Id
  private UUID id;

  //公司ID
  private UUID recId;

  //公司图片地址
  private String url;

  //公司图片次序
  private Integer pictureOrder;

  //创建时间
  private String createdOn;

  //修改时间
  private String updatedOn;

  /**
   * .
   */
  public CompanyPicture() {
  }

  public CompanyPicture(UUID id, UUID recId, String url, Integer pictureOrder, String createdOn, String updatedOn) {
    this.id = id;
    this.recId = recId;
    this.url = url;
    this.pictureOrder = pictureOrder;
    this.createdOn = createdOn;
    this.updatedOn = updatedOn;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public UUID getRecId() {
    return recId;
  }

  public void setRecId(UUID recId) {
    this.recId = recId;
  }

  public Integer getPictureOrder() {
    return pictureOrder;
  }

  public void setPictureOrder(Integer pictureOrder) {
    this.pictureOrder = pictureOrder;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public String getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(String updatedOn) {
    this.updatedOn = updatedOn;
  }
}
