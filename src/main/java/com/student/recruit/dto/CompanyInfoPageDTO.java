package com.student.recruit.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 带分页信息的公司信息 封装类.
 * Created by xiachao on 2017/3/14.
 */
public class CompanyInfoPageDTO implements Serializable {

  private static final long serialVersionUID = -4674871257665027707L;
  //公司信息数组
  private List<CompanyInfo> content;

  private boolean last;

  private Integer totalElements;

  private Integer totalPages;

  private Integer number;

  private Integer size;

  private Integer sort;

  private boolean first;

  private Integer numberOfElements;


  public CompanyInfoPageDTO() {
  }


  public List<CompanyInfo> getContent() {
    return content;
  }

  public void setContent(List<CompanyInfo> content) {
    this.content = content;
  }

  public boolean isLast() {
    return last;
  }

  public void setLast(boolean last) {
    this.last = last;
  }

  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public boolean isFirst() {
    return first;
  }

  public void setFirst(boolean first) {
    this.first = first;
  }

  public Integer getNumberOfElements() {
    return numberOfElements;
  }

  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }
}
