import org.junit.Test;

import common.li.Log;

public class test1 {
  @Test
  public void test2(){
    Log.debug("-----");
    Log.info(String.format("你好:%s%s",1<<4,"--"));
  }
}
