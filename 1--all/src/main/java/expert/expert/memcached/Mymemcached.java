package expert.expert.memcached;

import java.util.Date;

import org.junit.Test;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class Mymemcached {//memcached client
   @Test
  public void test1(){
    MemCachedClient me = new MemCachedClient();
    SockIOPool pool = SockIOPool.getInstance();
    String [] addr={"192.168.200.158:11211"};
    Integer [] weights={3};
    
    pool.setServers(addr);
    pool.setWeights(weights);
    pool.setInitConn(5);
    pool.setMinConn(5);
    pool.setMaxConn(200);
    pool.setMaxIdle(1000*30*30);
    pool.setMaintSleep(30);
    pool.setNagle(false);
    pool.setSocketTO(30);
    pool.setSocketConnectTO(0);
    pool.initialize();
    
    boolean b=me.set("a", "123",new Date(1000*10));//设置 key  value  过期时间  
    String s=(String)me.get("a");
    System.out.println(b+"");
    System.out.println(s+"   ");
   }
}
