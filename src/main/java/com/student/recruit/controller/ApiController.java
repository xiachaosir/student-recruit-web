package com.student.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minixiao.apiauth.client.HeaderUtil;
import com.student.recruit.dto.CompanyInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * 测试swagger .
 * Created by xiachao on 2017/3/9.
 */
@Controller
@RequestMapping("/api")
public class ApiController {
  private static RestTemplate restTemplate = new RestTemplate();

  private static ObjectMapper objectMapper = new ObjectMapper();

  private static final String URL = "http://127.0.0.1:8081/";

  @GetMapping("/index")
  @ApiOperation(value = "获取公司信息", notes = "哈哈哈 ")
  public ResponseEntity<String> index() {
    UUID userId = UUID.fromString("3ce67c6d-ec95-4642-b212-e1f7a4bced95");
    UUID recId = UUID.fromString("354bdb8f-ecd6-4c82-80fe-5f42db62d0a1");
    UUID id = UUID.fromString("354bdb8f-ecd6-4c82-80fe-5f42db6ad021");
    HttpHeaders httpHeaders = HeaderUtil.getHeader(userId, "夏超", "COMPANY",
        recId, "迷你校");
    HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(
        URL + "recruiter/" + recId + "/templates/content/" + id, HttpMethod.GET,
        requestEntity, String.class);
    String str = responseEntity.getBody();
    return ResponseEntity.ok(str);
  }

  @PostMapping("/save")
  @ApiOperation(value = "保存公司信息", notes = "接收公司信息body ")
  @ApiImplicitParam(name = "companyInfo", value = "公司实体", required = true, dataType = "CompanyInfo")
  public ResponseEntity<String> saveCompany(@RequestBody CompanyInfo companyInfo) {
    UUID userId = UUID.fromString("3ce67c6d-ec95-4642-b212-e1f7a4bced95");
    UUID recId = UUID.fromString("354bdb8f-ecd6-4c82-80fe-5f42db62d0a1");
    UUID id = UUID.fromString("354bdb8f-ecd6-4c82-80fe-5f42db6ad021");
    HttpHeaders httpHeaders = HeaderUtil.getHeader(userId, "夏超", "COMPANY",
        recId, "迷你校");
    HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(
        URL + "recruiter/" + recId + "/templates/content/" + id, HttpMethod.GET,
        requestEntity, String.class);
    String str = responseEntity.getBody();
    return ResponseEntity.ok(str);
  }


}
