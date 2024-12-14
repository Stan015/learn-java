package me.stanleyazi.AdvancedJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlJDBC {
  public static void main(String[] args) throws SQLException {
    // Creating the connection
    String url = "jdbc:postgresql://localhost:5433/testdb";
    Connection conn = null;

    int id = 3;
    String name = "Evenlyn Doe";
    String email = "Evenlyn@gmail.com";
    int age = 36;

    // write the sql statement to update db
    String sql = "insert into students(id, name, age, email)" + "values(" + id + ",'" + name + "'," + age + ",'" + email + "')";

    try {
      conn = DriverManager.getConnection(url, "stan015", "testpassword");

      Statement stmt = conn.createStatement();
      int count = stmt.executeUpdate(sql);
      if (count == 1) {
        System.out.println("Inserted successfully: " + sql);
      } else {
        System.out.println("Insertion failed");
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    } finally {
      if (conn != null) {
        conn.close();
      }
    }
  }
}
