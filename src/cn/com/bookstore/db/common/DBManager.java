package cn.com.bookstore.db.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
  public static Connection getConnection() {
    Connection conn = null;

    Properties pro = new Properties();
    InputStream is = null;
  
    try {
	  is = new BufferedInputStream(new FileInputStream("db.properties"));
      pro.load(is);
      String driver = pro.getProperty("driver");
      String url = pro.getProperty("url");
      String user = pro.getProperty("user");
      String password = pro.getProperty("password");
    	      
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      Release.free(is);
    }

    return conn;
  }

  public static void free(Connection conn, Statement st, ResultSet rs) {
    free(st, rs);
    free(conn);
  }
  
  public static void free(Statement st, ResultSet rs) {
    free(rs);
    free(st);
  }
  
  public static void free(Connection conn, Statement st) {
    free(st);
    free(conn);
  }
  
  public static void free(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void free(Statement st) {
    if (st != null) {
      try {
        st.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void free(Connection conn) {
    try {
      if (conn != null && !conn.isClosed()) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}