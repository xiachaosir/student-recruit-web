package com.student.recruit.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description 公司信息dto.
 * @Author xiachao
 * @CreateTime 2017/2/27 16:06
 */

public class CompanyInfo implements Serializable {
  private static final long serialVersionUID = -1806475692924418212L;
  //招聘企业的唯一识别ID
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

  List<CompanyPicture> pictures = new ArrayList<CompanyPicture>();

  //审核状态
  private String auditStatus;

  //来源
  private String source;

  //公司创建时间
  private String createdOn;

  // 公司修改时间
  private String updatedOn;


  public CompanyInfo() {
  }

  public CompanyInfo(UUID id, String fullName, String shortName, String slogan, String description, String subdomain, String recHref, String nature, String size, String primaryIndustry, String slaveIndustry, String city, String detailAddress, String website, String tags, String logo, List<CompanyPicture> pictures, String auditStatus, String source, String createdOn, String updatedOn) {
    this.id = id;
    this.fullName = fullName;
    this.shortName = shortName;
    this.slogan = slogan;
    this.description = description;
    this.subdomain = subdomain;
    this.recHref = recHref;
    this.nature = nature;
    this.size = size;
    this.primaryIndustry = primaryIndustry;
    this.slaveIndustry = slaveIndustry;
    this.city = city;
    this.detailAddress = detailAddress;
    this.website = website;
    this.tags = tags;
    this.logo = logo;
    this.pictures = pictures;
    this.auditStatus = auditStatus;
    this.source = source;
    this.createdOn = createdOn;
    this.updatedOn = updatedOn;
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

  public List<CompanyPicture> getPictures() {
    return pictures;
  }

  public void setPictures(List<CompanyPicture> pictures) {
    this.pictures = pictures;
  }

  public String getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(String auditStatus) {
    this.auditStatus = auditStatus;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
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

  @Override
  public String toString() {
    return "CompanyInfo{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", shortName='" + shortName + '\'' +
        ", slogan='" + slogan + '\'' +
        ", description='" + description + '\'' +
        ", subdomain='" + subdomain + '\'' +
        ", recHref='" + recHref + '\'' +
        ", nature='" + nature + '\'' +
        ", size='" + size + '\'' +
        ", primaryIndustry='" + primaryIndustry + '\'' +
        ", slaveIndustry='" + slaveIndustry + '\'' +
        ", city='" + city + '\'' +
        ", detailAddress='" + detailAddress + '\'' +
        ", website='" + website + '\'' +
        ", tags='" + tags + '\'' +
        ", logo='" + logo + '\'' +
        ", pictures=" + pictures +
        ", auditStatus='" + auditStatus + '\'' +
        ", source='" + source + '\'' +
        ", createdOn='" + createdOn + '\'' +
        ", updatedOn='" + updatedOn + '\'' +
        '}';
  }
}

