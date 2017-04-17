package com.student.recruit.utils;

import com.minixiao.apiauth.client.HeaderUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

/**
 * Created by xiachao on 2017/4/12.
 */
public class RecruiterFlowUtil {
  public static void main(String[] args) {
    /*Connection connection = ApplicationRecordUtil.getConnection();
    String sql = "select id from tb_rec_info";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      String id = rs.getString("id");
      RestTemplate restTemplate = new RestTemplate();
      UUID stuId = UUID.fromString(id);
      HttpHeaders httpHeaders = HeaderUtil.getHeader(stuId, "夏超", "COMPANY",
          stuId, "迷你校");
      HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
      ResponseEntity<String> responseEntity = restTemplate.exchange(
          "http://127.0.0.1:9112/recruiters/" + id + "/department/init", HttpMethod.POST,
          requestEntity, String.class);
      if (responseEntity.getStatusCodeValue() == 200) {
        System.out.println("id=" + id + "创建默认部门部门成功");
      }
    }*/
  }
}
