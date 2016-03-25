package expert.expert.queue.queue;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

/**
 * 
 * @ClassName: AbstractTaskQueue
 * @Description: 所有Queue的父类
 * @author lx
 * @date 2016-1-6 下午6:14:10
 *
 */
public abstract class AbstractTaskQueue extends LinkedBlockingQueue<ThirdPartyTask> {

  private static final long serialVersionUID = -3645243155204152472L;

  private static Logger logger = Logger.getLogger(AbstractTaskQueue.class);

  @Override
  public void put(ThirdPartyTask e) {
    try {
      super.put(e);
    } catch (InterruptedException ie) {
      logger.error("InterruptedException while put new task in", ie);
    }
  }

  
  /**
   * 取队列头部的一个Task对象
   */
  @Override
  public ThirdPartyTask take() {
    try {
      return super.take();
    } catch (InterruptedException ie) {
      logger.error("InterruptedException while put new task in", ie);
      return null;
    }
  }

  
}