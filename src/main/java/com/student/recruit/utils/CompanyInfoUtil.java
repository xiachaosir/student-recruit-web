package com.student.recruit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minixiao.apiauth.client.HeaderUtil;
import com.student.recruit.dto.CompanyInfo;
import com.student.recruit.dto.CompanyInfoOld;
import com.student.recruit.dto.CompanyInfoOldPageDTO;
import com.student.recruit.dto.CompanyInfoPageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

/**
 * 公司信息转换 新数据转换成老数据结构.
 * Created by xiachao on 2017/3/13.
 */
public class CompanyInfoUtil {

  private static Logger logger = LoggerFactory.getLogger(CompanyInfoUtil.class);

  private static RestTemplate restTemplate = new RestTemplate();

  private static ObjectMapper objectMapper = new ObjectMapper();

  private static final String URL = "http://127.0.0.1:9112/";

  /**
   * @Description 获取带分页信息的公司列表.
   * @Author xiachao
   * @CreateTime 2017/3/13 16:25
   * @Param
   * @Return
   */
  public static String getPageCompanyInfo() {
    UUID userId = UUID.fromString("3ce67c6d-ec95-4642-b212-e1f7a4bced95");
    UUID recId = UUID.fromString("354bdb8f-ecd6-4c82-80fe-5f42db62d0a1");
    HttpHeaders httpHeaders = HeaderUtil.getHeader(userId, "夏超", "COMPANY",
        recId, "迷你校");
    HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(
        URL + "companies", HttpMethod.GET,
        requestEntity, String.class);
    String str = responseEntity.getBody();
    return str;
  }

  /**
   * @Description 获取单个公司信息 以新数据格式返回.
   * @Author xiachao
   * @CreateTime 2017/3/13 16:26
   * @Param
   * @Return
   */
  public static CompanyInfo getCompanyInfo() {
    UUID userId = UUID.fromString("3ce67c6d-ec95-4642-b212-e1f7a4bced95");
    UUID recId = UUID.fromString("1a7bd28f-e5d6-4cc2-80fe-5f42db68d0a2");
    HttpHeaders httpHeaders = HeaderUtil.getHeader(userId, "夏超", "COMPANY",
        recId, "迷你校");
    HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(
        URL + "companies/" + recId, HttpMethod.GET,
        requestEntity, String.class);
    String str = responseEntity.getBody();
    CompanyInfo companyInfo = new CompanyInfo();
    try {
      companyInfo = objectMapper.readValue(str, CompanyInfo.class);
    } catch (IOException e) {
      logger.error("json字符串转换为公司对象出错");
      e.printStackTrace();
    }
    return companyInfo;
  }

  /**
   * @Description 单个公司对象转换成老数据的结构.
   * @Author xiachao
   * @CreateTime 2017/3/13 16:37
   * @Param
   * @Return
   */
  public static CompanyInfoOld convertCompany(CompanyInfo companyInfo) {
    CompanyInfoOld companyInfoOld = new CompanyInfoOld();
    if (companyInfo != null) {
      companyInfoOld.setAccId(companyInfo.getId());
      companyInfoOld.setcName(companyInfo.getFullName());
      companyInfoOld.setAddress(companyInfo.getDetailAddress());
      companyInfoOld.setLogo(companyInfo.getLogo());
      companyInfoOld.setNature(companyInfo.getNature());
      companyInfoOld.setTag(companyInfo.getTags());
      companyInfoOld.setTrade(companyInfo.getPrimaryIndustry());
      companyInfoOld.setSize(companyInfo.getSize());
      companyInfoOld.setWord(companyInfo.getSlogan());
      //暂时写死 到时候掉诗雨接口
      companyInfoOld.setpCount(100);
    }
    return companyInfoOld;
  }


  /**
   * @Description 公司列表转换成就数据格式.
   * @Author xiachao
   * @CreateTime 2017/3/14 18:34
   * @Param
   * @Return
   */
  public static ResponseEntity<CompanyInfoPageDTO> getPageCompany(String pageCompany) {
    if (pageCompany != null) {
      CompanyInfoPageDTO companyInfoPageDTO = new CompanyInfoPageDTO();
      try {
        companyInfoPageDTO = objectMapper.readValue(pageCompany, CompanyInfoPageDTO.class);
        return ResponseEntity.ok(companyInfoPageDTO);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .cacheControl(CacheControl.noCache())
        .body(null);
  }

  /**
   * @Description 新数据格式转换为就数据格式 page.
   * @Author xiachao
   * @CreateTime 2017/3/15 17:26
   * @Param
   * @Return
   */
  public static CompanyInfoOldPageDTO getCompanyInfoPageDTO() {
    String str = CompanyInfoUtil.getPageCompanyInfo();
    System.out.println(str);
    try {
      CompanyInfoPageDTO companyInfoPageDTOList = objectMapper.readValue(str, CompanyInfoPageDTO.class);
      List<CompanyInfo> companyInfoList = companyInfoPageDTOList.getContent();
      List<CompanyInfoOld> oldList = new ArrayList<CompanyInfoOld>();
      for (int i = 0; i < companyInfoList.size(); i++) {
        CompanyInfo companyInfo = companyInfoList.get(i);
        CompanyInfoOld companyInfoOld = convertCompany(companyInfo);
        oldList.add(companyInfoOld);
      }
      CompanyInfoOldPageDTO companyInfoOldPageDTO = new CompanyInfoOldPageDTO();
      companyInfoOldPageDTO.setData(oldList);

      // pageSize 当前页有多少条记录
      companyInfoOldPageDTO.setPageSize(companyInfoPageDTOList.getSize());

      // pageNo 当前页
      companyInfoOldPageDTO.setPageNo(companyInfoPageDTOList.getNumber());

      //totalPage 总共多少页
      companyInfoOldPageDTO.setTotalPage(companyInfoPageDTOList.getTotalPages());

      //总共有多少条记录
      companyInfoOldPageDTO.setTotalCount(companyInfoPageDTOList.getTotalElements());

      String oldStr = objectMapper.writeValueAsString(companyInfoOldPageDTO);
      System.out.println("-----输出老的数据格式-----");
      System.out.println(oldStr);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  public static void main(String[] args) {
    // System.out.println(getCompanyInfo());
    //CompanyInfoUtil.getCompanyInfoPageDTO();
    /*String str = "10000032";
    System.out.println(str.length());
    System.out.println(str.substring(0,str.length()-2));*/
   /* UUID userId = UUID.fromString("3ce67c6d-ec95-4642-b212-e1f7a4bced95");
    UUID recId = UUID.fromString("26c260f8-b4c2-49ad-9ee3-629af9881d41");
    HttpHeaders httpHeaders = HeaderUtil.getHeader(userId, "夏超", "COMPANY",
        recId, "迷你校");
    HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(
        "http://127.0.0.1:9112/recruiters/" + recId + "/time", HttpMethod.GET,
        requestEntity, String.class);
    String str = responseEntity.getBody();
    System.out.println(str);*/
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);
    DayOfWeek week = localDateTime.getDayOfWeek();
    System.out.println(week.toString());
    LocalDateTime localDateTime1 = localDateTime.plusDays(-7);
    System.out.println(localDateTime1);
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
    System.out.println(localDate.atStartOfDay());
    System.out.println(localDate.minusMonths(100));


    /*LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);
    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    System.out.println(timestamp);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    String data = formatter.format(timestamp);
    System.out.println(data);*/

  }


}
