package expert.expert.queue.queue.notifyThreadPool;

import java.util.Map;

/**
 * 通知参数,可以由配置notify.xml来修改参数
 * 
 * 
 */
public class NotifyParam {

	private Map<Integer, Integer> notifyParams;// 通知时间次数map
	private String successValue;// 通知后用于判断是否成功的返回值。由HttpResponse获取
	
	private static NotifyParam notifyParam ;
	
	private  NotifyParam(){
	}
	
	
	public static synchronized NotifyParam getInstance(){
	  if(notifyParam==null){
      notifyParam=new NotifyParam();
	  }
	  return notifyParam;
	}
	
	public Map<Integer, Integer> getNotifyParams() {
		return notifyParams;
	}

	public void setNotifyParams(Map<Integer, Integer> notifyParams) {
		this.notifyParams = notifyParams;
	}

	public String getSuccessValue() {
		return successValue;
	}

	public void setSuccessValue(String successValue) {
		this.successValue = successValue;
	}

	public Integer getMaxNotifyTime() {
		return notifyParams == null ? 0 : notifyParams.size();
	}

}
