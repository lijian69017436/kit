package expert.expert.queue.queue;

import org.junit.Test;

public class Test_smsqueue {

  @Test
  public void test_queue(){
    partyTask partyTask = new partyTask();
    partyTask.setName("123");
    SMSQueue.getInstance().put(partyTask); //压栈  对象
    
    partyTask partyTask1 = new partyTask();
    partyTask1.setName("李建");
    SMSQueue.getInstance().put(partyTask1);
    
    partyTask partyTask2 = new partyTask();
    partyTask2.setName("理想");
    SMSQueue.getInstance().put(partyTask2);
   
    partyTask take = (partyTask)SMSQueue.getInstance().take();
    System.out.println(take.getName());
    partyTask take1 = (partyTask)SMSQueue.getInstance().take();
    System.out.println(take1.getName());
    partyTask take2 = (partyTask)SMSQueue.getInstance().take();
    System.out.println(take2.getName());
  }
}


class partyTask extends ThirdPartyTask{
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}