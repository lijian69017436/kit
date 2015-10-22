package expert.expert.redis;

import org.junit.Test;

public class TestCache {

    @Test 
  public void TestCaches(){
      CacheManager.setup("192.168.0.3:6379", "test:lijian", "");
      CacheClient ca= CacheManager.getClient();
      ca.set("lijia", "22");
      ca.set("lijian", "123");
      System.out.println(ca.get("lijian"));
      System.out.println(ca.get("lijia"));
  
  }
    @Test
    public void Testc(){
      CacheManager.setup("192.168.0.3:6379", "test:lijian", "");
      CacheClient ca= CacheManager.getClient();
      System.out.println(ca.get("lijian"));
    }
  
//spring   初始化 注入
//    <bean class="com.RedisCacheClient">
  //    <constructor-arg value="10.252.31.10:6379" />
  //    <constructor-arg value="smartad:ad" />
  //    <constructor-arg value="xbwx!@345678()" />
//    </bean>
}
