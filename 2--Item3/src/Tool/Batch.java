package Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Batch {
  //batch 批量处理
  public static void main(String[] args) {
    new Batch().executeBatch();
  }
  
  public void executeBatch(){
    long l1=System.currentTimeMillis();
    Connection conn=Tool.getToolInstance().getconn();
    String sql="insert into tongxun( id, name, sex, unit, address, mobile, mobile1,email) values(?,?,?,?,?,?,?,?)";
   
    try {
      conn.setAutoCommit(false);//在java 对数据库操作时，可以手动体提交事务
      PreparedStatement pre=conn.prepareStatement(sql);
      for(int i=4;i<=50;i++){
        pre.setInt(1, i);
        pre.setString(2, "ee");
        pre.setString(3,"e");
        pre.setString(4, "r");
        pre.setString(5, "t");
        pre.setInt(6, 1);
        pre.setString(7, "s");
        pre.setString(8, "5");
      
        pre.addBatch();//将添加号参数的sql放置到批处理的方法中
        
      }
      int arr[]=pre.executeBatch();//使用pre对象，调用批处理，对数据库进行操作
      conn.commit();//提交事务
      long l2=System.currentTimeMillis();
      
      System.out.println("程序运行的时间："+(l2-l1));
      for(int i=0;i<arr.length;i++){//输出对数据库操做时返回值，看看是否操作成功
        System.out.print(arr[i]+"\t");
        if(i%10==0){//计数器，用于一行10个返回值，然后换行
          System.out.println();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  
  
}
