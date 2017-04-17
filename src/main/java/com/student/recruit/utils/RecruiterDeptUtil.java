package com.student.recruit.utils;

import com.minixiao.apiauth.client.HeaderUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by xiachao on 2017/4/12.
 */
public class RecruiterDeptUtil {
  public static Connection getConnection() {
    Connection connection = null;
    String url = "jdbc:postgresql://192.168.1.250:5432/recruiter";
    String user = "postgres";
    String pwd = "q3nzqd63jrk3gvqmdtzc6ui33mqiefj6";
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, user, pwd);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return connection;
  }

  // ps: 创建默认部门之前 需先处理没有公司全称的数据
  public static void main(String[] args) throws SQLException {
    Connection connection = RecruiterDeptUtil.getConnection();
    String sql = "select id from tb_rec_info";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      String id = rs.getString("id");
      System.out.println("id=" + id + "开始创建");
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
    }

  }
}
