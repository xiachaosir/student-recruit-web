package com.student.recruit.utils;

import com.minixiao.apiauth.client.HeaderUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 将学生信息导入到投递表的resume字段中
 * Created by xiachao on 2017/3/28.
 */
public class ApplicationRecordUtil {


  public static Connection getConnection() {
    Connection connection = null;
    String url = "jdbc:postgresql://114.55.27.66:5432/student";
    String user = "postgres";
    String pwd = "q3nzqd63jrk3gvqmdtzc6ui33mqiefj8";
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

  public static void main(String[] args) {
    Connection connection = ApplicationRecordUtil.getConnection();
    String sql = "select id,stu_id,job_id from tb_stu_application_record where resume is null";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      int flag = 1;
      while (resultSet.next()) {
        System.out.println("第" + flag + "条  id=" + resultSet.getString("id") + " stuId = " + resultSet.getString("stu_id") + "  jobId=" + resultSet.getString("job_id"));
        System.out.println("执行update 将学生简历信息更新到记录表中");
        String stu_id = resultSet.getString("stu_id");
        String job_id = resultSet.getString("job_id");
        RestTemplate restTemplate = new RestTemplate();
        UUID stuId = UUID.fromString(stu_id);
        UUID jobId = UUID.fromString(job_id);
        HttpHeaders httpHeaders = HeaderUtil.getHeader(stuId, "夏超", "COMPANY",
            jobId, "迷你校");
        HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
            "http://127.0.0.1:9111/student/" + stuId + "/application/" + jobId, HttpMethod.POST,
            requestEntity, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
          System.out.println("更新成功");
          flag++;
        }
        LocalDateTime localDateTime = LocalDateTime.now().plusWeeks(-7);
        System.out.println(localDateTime);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }


  }
}
