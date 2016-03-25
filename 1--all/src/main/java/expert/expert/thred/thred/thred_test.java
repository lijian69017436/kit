package expert.expert.thred.thred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import common.li.util.UuidUtil;

//怎么使用线程池
public class thred_test {

  int numThred=15; //几个线程
  
  @Test 
  public void test_1(){
    ExecutorService pool = Executors.newScheduledThreadPool(numThred); //线程池 
    for(int i=0;i<9000;i++){ 
        pool.execute(new thredTest());
    }
  }
  
}


//线程 实现类  执行具体的业务逻辑 
class thredTest implements Runnable{
  public void run() {
    System.out.println(Thread.currentThread().getName()+"    "+UuidUtil.getOrderNo("df"));
  }
}
  

