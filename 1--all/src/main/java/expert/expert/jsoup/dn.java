package expert.expert.jsoup;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 是什么: 龙之谷
 * 做什么: 能够刷团购页面请求  
 * @ClassName: dn 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年4月22日 上午9:06:34 
 *
 */
public class dn {
 public static long i=0;
 int numThred=15; //几个线程
  
 @Test
  public void testDn(){
   // ExecutorService pool = Executors.newScheduledThreadPool(numThred); //线程池 
    for(int i=0;i<90000000;i++){
        dn.i++;
       // System.out.println(i);
        String o;
        try {
          o = Jsoups.requerstUrl("http://groupon.sdo.com/groupondetail.aspx?id=510", "get");
          Thread.sleep(400);
          System.out.println(dn.i);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        //pool.execute(new thredTestd());
    }
  }
  
  
  
}







//线程 实现类  执行具体的业务逻辑 
class thredTestd implements Runnable{
  public void run() {
    System.out.println(1);
  }
}