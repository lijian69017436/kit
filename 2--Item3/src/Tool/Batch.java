package Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Batch {
  //batch ��������
  public static void main(String[] args) {
    new Batch().executeBatch();
  }
  
  public void executeBatch(){
    long l1=System.currentTimeMillis();
    Connection conn=Tool.getToolInstance().getconn();
    String sql="insert into tongxun( id, name, sex, unit, address, mobile, mobile1,email) values(?,?,?,?,?,?,?,?)";
   
    try {
      conn.setAutoCommit(false);//��java �����ݿ����ʱ�������ֶ����ύ����
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
      
        pre.addBatch();//����ӺŲ�����sql���õ�������ķ�����
        
      }
      int arr[]=pre.executeBatch();//ʹ��pre���󣬵��������������ݿ���в���
      conn.commit();//�ύ����
      long l2=System.currentTimeMillis();
      
      System.out.println("�������е�ʱ�䣺"+(l2-l1));
      for(int i=0;i<arr.length;i++){//��������ݿ����ʱ����ֵ�������Ƿ�����ɹ�
        System.out.print(arr[i]+"\t");
        if(i%10==0){//������������һ��10������ֵ��Ȼ����
          System.out.println();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  
  
}
