package expert.expert.queue.queue.notifyThreadPool;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class NotifyQueue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOG = LogFactory.getLog(NotifyQueue.class);


	/**
	 * 将传过来的对象进行通知次数判断，之后决定是否放在任务队列中
	 * 
	 * @param notifyRecordMerchant
	 * @throws Exception
	 */
	public void addElementToList(NotifyRecord notifyRecord) {
		if (notifyRecord == null) {
			return;
		}
		Integer notifyTimes = notifyRecord.getNotifyTimes(); // 通知次数
		Integer maxNotifyTime = 0;
		maxNotifyTime = NotifyParam.getInstance().getMaxNotifyTime()+1; //得到 设置的最大通知次数
		
		if (notifyTimes < maxNotifyTime) { //判断通知次数  
				notifyRecord.setLastNotifyTime(new Date());
				App.tasks.put(new NotifyTask(notifyRecord, this, NotifyParam.getInstance()));
		} else {
				//记录日志
				LOG.info("Update NotifyRecord failed,merchantNo:" + notifyRecord.getMerchantNo() + ",merchantOrderNo:"
						+ notifyRecord.getMerchantOrderNo());
		}
		
	}



	
}
