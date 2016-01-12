package common.li;

public class StringUtil {

  /**
   * 
   * @param str
   * @return true 空   false 非空
   */
  public static boolean isNull(String str){
    // isEmpty() 为空  返回true
    if("".equals(str)|| null==str ||  str.trim().isEmpty()){
      return true;
    }else{
      return false;
    }
  }
}
