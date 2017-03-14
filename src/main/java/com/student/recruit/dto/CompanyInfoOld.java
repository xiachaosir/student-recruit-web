package com.student.recruit.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by xiachao on 2017/3/13.
 */
public class CompanyInfoOld implements Serializable {

  private static final long serialVersionUID = 5766174385844102734L;
  private UUID accId;

  private String cName;

  private String nature;

  private String address;

  private String size;

  private String trade;

  private String tag;

  private Integer pCount;

  private String word;

  private String logo;

  public CompanyInfoOld() {
  }

  public CompanyInfoOld(UUID accId, String cName, String nature, String address, String size, String trade, String tag, Integer pCount, String word, String logo) {
    this.accId = accId;
    this.cName = cName;
    this.nature = nature;
    this.address = address;
    this.size = size;
    this.trade = trade;
    this.tag = tag;
    this.pCount = pCount;
    this.word = word;
    this.logo = logo;
  }

  public UUID getAccId() {
    return accId;
  }

  public void setAccId(UUID accId) {
    this.accId = accId;
  }

  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getTrade() {
    return trade;
  }

  public void setTrade(String trade) {
    this.trade = trade;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public Integer getpCount() {
    return pCount;
  }

  public void setpCount(Integer pCount) {
    this.pCount = pCount;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }
}
