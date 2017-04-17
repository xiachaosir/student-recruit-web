package com.student.recruit.dto;

import java.util.List;

/**
 * Created by xiachao on 2017/3/15.
 */
public class CompanyInfoOldPageDTO {

  private List<CompanyInfoOld> data;

  private Integer pageNo;

  private Integer totalPage;

  private Integer pageSize;

  private Integer totalCount;


  public CompanyInfoOldPageDTO() {
  }

  public CompanyInfoOldPageDTO(List<CompanyInfoOld> data, Integer pageNo, Integer totalPage, Integer pageSize, Integer totalCount) {
    this.data = data;
    this.pageNo = pageNo;
    this.totalPage = totalPage;
    this.pageSize = pageSize;
    this.totalCount = totalCount;
  }

  public List<CompanyInfoOld> getData() {
    return data;
  }

  public void setData(List<CompanyInfoOld> data) {
    this.data = data;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(Integer totalPage) {
    this.totalPage = totalPage;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }
}
