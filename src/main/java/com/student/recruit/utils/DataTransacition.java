package com.student.recruit.utils;

import org.springframework.cache.annotation.Cacheable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * Created by xiachao on 2017/3/22.
 */
public class DataTransacition {


  public static Connection getConnection() {
    Connection connection = null;
    String url = "jdbc:postgresql://192.168.1.250:5432/recruitinfo";
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
    Statement statement = null;
    Connection connection = null;
    try {
      String sql = "select id,substring(primary_industry from 0 for position('-' in primary_industry) ) from tb_comp_info where primary_industry != '' and primary_industry is not null ";
      connection = DataTransacition.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String id = resultSet.getString("id");
        UUID compId = UUID.fromString(id);
        String industrySmall = resultSet.getString("substring");

        System.out.println("compId=" + compId);
        System.out.println("industry_small=" + industrySmall);
        if (industrySmall != null) {
          String sql2 = "update tb_comp_info set industry_small = ? where cast(id as varchar)= ?";
          PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
          preparedStatement1.setString(1, industrySmall);
          preparedStatement1.setString(2, id);
          preparedStatement1.execute();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

}
