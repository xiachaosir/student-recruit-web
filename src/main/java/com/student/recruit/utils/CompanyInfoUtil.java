package com.student.recruit.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minixiao.apiauth.client.HeaderUtil;
import com.student.recruit.dto.CompanyInfo;
import com.student.recruit.dto.CompanyInfoOld;
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
import java.util.UUID;

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
  public static String convertCompany(CompanyInfo companyInfo) {
    if (companyInfo != null) {
      CompanyInfoOld companyInfoOld = new CompanyInfoOld();
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
      String str = "";
      try {
        str = objectMapper.writeValueAsString(companyInfoOld);
        return str;
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return null;
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


  public static void main(String[] args) {

    /*CompanyInfo companyInfo = CompanyInfoUtil.getCompanyInfo();
    String str = CompanyInfoUtil.convertCompany(companyInfo);
    System.out.println(str);*/
    String str = CompanyInfoUtil.getPageCompanyInfo();
    System.out.println(str);


    /*ResponseEntity<CompanyInfoPageDTO> companyInfoPageDTO = CompanyInfoUtil.getPageCompany(str);
    CompanyInfoPageDTO result = companyInfoPageDTO.getBody();
    System.out.println(result);*/

  }


}
