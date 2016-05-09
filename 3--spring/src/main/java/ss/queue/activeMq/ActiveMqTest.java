package ss.queue.activeMq;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * 测试 activemq队列 
 * @ClassName: ActiveMqTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年5月9日 上午10:43:20 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-activemq.xml")
public class ActiveMqTest {
  

  
  @Resource(name="notifyJmsTemplate")
  JmsTemplate jmsTemplate;
  
  @Test
  public void sendMsg(){
    jmsTemplate.send(new MessageCreator() {
      @Override
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("123");
      }
    });
  }
}



/**
 * 消费者
 * @ClassName: MessageListener 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年5月9日 下午2:15:39 
 */
class MessageListener implements SessionAwareMessageListener<Message> {
  int i=0;
  public synchronized void onMessage(Message message, Session session) {
    try {
      ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
      final String ms = msg.getText();
      
      System.out.println(i+ "== receive message:" + ms);
      i++;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
