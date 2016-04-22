package expert.expert.queue.queue;

import java.util.UUID;

/**
 *  队列里边存放的 父类  用来标示这个已经存放过
 * 
 * @author Bai Song
 * @version 1.0
 */
public abstract class ThirdPartyTask {

  private UUID taskID;

  public static final String TASK_ID = "TaskID";

  /**
   * 生成一个新的taskID
   */
  public ThirdPartyTask() {
    System.out.println("初始化  队列对象  父类 ");
    this.taskID = UUID.randomUUID();
  }
  

  public ThirdPartyTask(UUID taskID) {
    this.taskID = taskID;
  }

  
  /**
   * @return the taskID
   */
  public UUID getTaskID() {
    return taskID;
  }
  
  

}