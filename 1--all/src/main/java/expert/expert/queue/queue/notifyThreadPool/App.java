package expert.expert.queue.queue.notifyThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * 通知  线程池 处理
 */

public class App  {

	private  Logger logger = Logger.getLogger(App.class);

	public static DelayQueue<NotifyTask> tasks = new DelayQueue<NotifyTask>();

	public  ThreadPoolTaskExecutor threadPool;



	public static void main(String[] args) {
    new App().init();
  }

	@Test
	public  void init() {
		try {
		  add_threadPool();
			startThread();
			logger.info("==  支付 业务队列 处理程序已经启动  start--");
		} catch (Exception e) {
		  logger.error("== 支付 业务队列 处理程序  start error:", e);
			return;
		}
	}
	@Test
	public void add_threadPool(){
	  NotifyRecord notify = new NotifyRecord();
	  notify.setId("123");
	  notify.setUrl("lijian.com");
	  NotifyQueue notifyQueue = new NotifyQueue();
	 
	  Map<Integer, Integer> notifyParams = new HashMap<>();
    notifyParams.put(1, 1);
    notifyParams.put(2, 2);
    notifyParams.put(3, 3);
    notifyParams.put(4, 4);
    NotifyParam.getInstance().setNotifyParams(notifyParams);
    
	  notifyQueue.addElementToList(notify);
	}
	

	private  void startThread() {
	  //线程队列
	  threadPool=new ThreadPoolTaskExecutor();
	  threadPool.setCorePoolSize(50); //线程池维护的最少线程数量
	  threadPool.setKeepAliveSeconds(30000);//准许的空闲时间
	  threadPool.setMaxPoolSize(200);//最大 线程数量
	  threadPool.setQueueCapacity(1000);//所使用的缓冲队列
	  threadPool.initialize();
	  
		threadPool.execute(new Runnable() {
			public void run() {
				try {
					while (true) {
						// 如果当前活动线程等于最大线程，那么不执行
						if (threadPool.getActiveCount() < threadPool.getMaxPoolSize()) {
							final NotifyTask task = tasks.poll();
							if (task != null) {
								threadPool.execute(new Runnable() {
									public void run() {
									  logger.debug("执行任务中的线程数总数:"+threadPool.getActiveCount()+"  当前线程"+Thread.currentThread().getName() + "---------");
										tasks.remove(task);
										task.run();
									}
								});
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 


}
