package Tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Tool {
  private  Tool(){
  }
  public  static Tool getToolInstance(){
    return new Tool();
  }
  public Connection getconn(){
    Connection conn=null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
       conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/item","root","111");
    } catch (ClassNotFoundException e) {
      System.out.println("Çý¶¯´íÎó ");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("Á¬½Ó´íÎó");
      e.printStackTrace();
    }
    return conn;
  }
}
