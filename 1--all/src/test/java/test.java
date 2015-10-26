import org.junit.Test;

import common.li.Log;

public class test {
  @Test
  public void test(){
    Log.debug(String.format("你好:%s%s",1<<4,"--"));
  }
}
