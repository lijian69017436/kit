package expert.expert.queue.queue.notifyThreadPool;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 执行通知的类，以后有业务时添加业务代码即可
 */
public  class NotifyTask implements Runnable, Delayed {

	private static final Log LOG = LogFactory.getLog(NotifyTask.class);

	private long executeTime;

	private NotifyRecord notifyRecord;

	private NotifyQueue notifyQueue;

	private NotifyParam notifyParam;

	public NotifyTask() {
	}

	public NotifyTask(NotifyRecord notifyRecord, NotifyQueue notifyQueue, NotifyParam notifyParam) {
		super();
		this.notifyRecord = notifyRecord;
		this.notifyQueue = notifyQueue;
		this.notifyParam = notifyParam;
		this.executeTime = getExecuteTime(notifyRecord);
	}

	private long getExecuteTime(NotifyRecord record) {
		long lastTime = record.getLastNotifyTime().getTime();
		Integer nextNotifyTime = notifyParam.getNotifyParams().get(record.getNotifyTimes());
		return (nextNotifyTime == null ? 0 : nextNotifyTime * 1000) + lastTime;
	}

	 @Override
   public int compareTo(Delayed o) {
      NotifyTask task = (NotifyTask) o;
      return executeTime > task.executeTime ? 1 : (executeTime < task.executeTime ? -1 : 0);
   }

  @SuppressWarnings("static-access")
  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert(executeTime - System.currentTimeMillis(), unit.SECONDS);
  }

	
   
	public void run() {
	  // 得到当前通知对象的通知次数  并+1
    Integer notifyTimes = notifyRecord.getNotifyTimes();
    notifyRecord.setNotifyTimes(notifyTimes+1);
    // 去通知
    try {
      LOG.info("Notify Url " + notifyRecord.getUrl());
      /** 采用 jsoup 请求 url  */
    
      
      notifyQueue.addElementToList(notifyRecord);
    } catch (Exception e) {
      LOG.error("NotifyTask", e);
      notifyQueue.addElementToList(notifyRecord);
    }
    
	}
  
	
}
