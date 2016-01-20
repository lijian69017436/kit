package expert.expert.thred.thred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import common.li.util.UuidUtil;


public class thred_test {

  @Test 
  public void dd(){
    ExecutorService pool = Executors.newScheduledThreadPool(15); //线程池 
    
    for(int i=0;i<9000;i++){ //用 10个 线程 执行 200个 任务
        pool.execute(new Runnable() { 
          
          @Override
          public void run() {
            System.out.println(Thread.currentThread().getName()+"    "+UuidUtil.getOrderNo("df"));
          }
        });
    }
  }
}
