package expert.expert.email;

import java.util.Properties;

import org.junit.Test;
import common.li.Log;



public class TestEmail {

  Properties pro=new Properties();
  
  @Test
  public void alarm() { 
    
    String subject = "介绍";
    StringBuffer body=new StringBuffer();
    body.append("nihao  \n");
    body.append("my  name is  lijian  \n");
    try{
      pro.load(this.getClass().getResourceAsStream("mail.properties")); //  根路径 加 /
      EmailSender.sendEmail(pro, subject, body.toString(), "text/plain; charset=UTF-8");
      Log.info("邮件已发送");
    } catch (Exception e){
      Log.error("发送邮件失败"+ e);
    }
  }
  
  
}
