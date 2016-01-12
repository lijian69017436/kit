import java.util.HashMap;

import org.junit.Test;

import common.li.Log;

public class test1 {
  @Test
  public void test2(){
    Log.debug("-----");
    HashMap<Object, Object> map = new HashMap<>();
    map.put("123", "213");
    map.put("1233", "213");
    System.out.println(map.toString());
    Log.info(String.format("你好:%s%s",1<<4,"--"));
  }
}
