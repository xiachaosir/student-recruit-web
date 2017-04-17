package com.student.recruit.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by xiachao on 2017/3/20.
 */
public class RecruiterInfoDTO {

  //发布公司的唯一识别ID
  private UUID id;

  //公司全称
  private String fullName;

  //公司简称
  private String shortName;

  //公司一句话介绍
  private String slogan;

  //公司描述
  private String description;

  //公司子域名
  private String subdomain;

  //招聘企业定制页面链接
  private String recHref;

  //公司性质
  private String nature;

  //公司规模
  private String size;

  //公司一级行业
  private String primaryIndustry;

  //公司二级行业
  private String slaveIndustry;

  //公司省市
  private String city;

  //公司详细地址
  private String detailAddress;

  //公司官方网站
  private String website;

  //公司标签--以英文状态逗号切分
  private String tags;

  //公司logo地址
  private String logo;

  //销售信息
  private String salesInfo;

  //客户级别
  private String scale;

  //公司开始时间 默认为创建时间 不可修改
  private LocalDate validityStart;


  //公司有效期 不可修改
  private LocalDate validityEnd;

  public RecruiterInfoDTO() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSubdomain() {
    return subdomain;
  }

  public void setSubdomain(String subdomain) {
    this.subdomain = subdomain;
  }

  public String getRecHref() {
    return recHref;
  }

  public void setRecHref(String recHref) {
    this.recHref = recHref;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getPrimaryIndustry() {
    return primaryIndustry;
  }

  public void setPrimaryIndustry(String primaryIndustry) {
    this.primaryIndustry = primaryIndustry;
  }

  public String getSlaveIndustry() {
    return slaveIndustry;
  }

  public void setSlaveIndustry(String slaveIndustry) {
    this.slaveIndustry = slaveIndustry;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getSalesInfo() {
    return salesInfo;
  }

  public void setSalesInfo(String salesInfo) {
    this.salesInfo = salesInfo;
  }

  public String getScale() {
    return scale;
  }

  public void setScale(String scale) {
    this.scale = scale;
  }

  public LocalDate getValidityStart() {
    return validityStart;
  }

  public void setValidityStart(LocalDate validityStart) {
    this.validityStart = validityStart;
  }

  public LocalDate getValidityEnd() {
    return validityEnd;
  }

  public void setValidityEnd(LocalDate validityEnd) {
    this.validityEnd = validityEnd;
  }
}
