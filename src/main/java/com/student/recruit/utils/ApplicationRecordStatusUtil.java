package com.student.recruit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiachao on 2017/3/31.
 */
public class ApplicationRecordStatusUtil {
  public static Connection getConnection() {
    Connection connection = null;
    String url = "jdbc:postgresql://192.168.1.250:5432/student";
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

  public static void main(String[] args) {
    Connection connection = ApplicationRecordStatusUtil.getConnection();
    PreparedStatement ps = null;
    String sql = "select  cast(c_status as varchar),uuid_positionid,uuid_stuid from tn_delivery";
    try {
      ps = connection.prepareStatement(sql);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        String cStatus = resultSet.getString("c_status");
        String positionId = resultSet.getString("uuid_positionid");
        String stuId = resultSet.getString("uuid_stuid");
        String sql2 = "update tb_stu_application_record set stage = ? where cast(job_id as varchar) = ? and cast(stu_id as varchar) = ?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        if ("1".equals(cStatus) || "4".equals(cStatus)) {
          ps2.setString(1, "wait_screen");
        } else if ("6".equals(cStatus) || "3".equals(cStatus) || "3".equals(cStatus)) {
          ps2.setString(1, "screening");
        } else if ("2".equals(cStatus)) {
          ps2.setString(1, "not_pass");
        } else if ("10".equals(cStatus)) {
          ps2.setString(1, "offer");
        }
        ps2.setString(2, positionId);
        ps2.setString(3, stuId);
        int tmp = ps2.executeUpdate();
        if (tmp > 0) {
          System.out.println("positionId=" + positionId + "stuId=" + stuId + "------更新成功");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
    /*Connection connection = ApplicationRecordStatusUtil.getConnection();
    PreparedStatement ps = null;
    String sql = "SELECT t1.flow_name,t2.uuid_positionid,t2.uuid_stuid from t_account_resume_flow t1,tn_delivery t2 where t2.status = t1.resume_flow_id and t2.acc_id = 3582 ";
    try {
      ps = connection.prepareStatement(sql);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        String flow_name = resultSet.getString("flow_name");
        String positionId = resultSet.getString("uuid_positionid");
        String stuId = resultSet.getString("uuid_stuid");

        String sql2 = "update tb_stu_application_record set stage = ? where cast(job_id as varchar) = ? and cast(stu_id as varchar) = ?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        if (flow_name != null && "初筛".equals(flow_name)) {
          ps2.setString(1, "wait_screen");
        } else if (flow_name != null && "面试".equals(flow_name)) {
          ps2.setString(1, "screening");
        } else if (flow_name != null && "笔试".equals(flow_name)) {
          ps2.setString(1, "screening");
        } else if (flow_name != null && "录用".equals(flow_name)) {

        }

        ps2.setString(2, positionId);
        ps2.setString(3, stuId);
        int tmp = ps2.executeUpdate();
        {
          if (tmp > 0) {
            System.out.println(" positionId =" + positionId + " stuId=" + stuId + "--------更新成功");
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }*/
}
