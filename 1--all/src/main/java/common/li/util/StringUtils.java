package common.li.util;

/**
 * 
 * @ClassName: StringUtils 
 * @Description: TODO(string 的 工具类) 
 * @author lijian 
 * @date 2015年12月23日 下午4:36:37 
 *
 */
public class StringUtils {

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
