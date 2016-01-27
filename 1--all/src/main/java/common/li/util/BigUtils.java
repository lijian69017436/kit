package common.li.util;

import java.math.BigDecimal;

public class BigUtils {

  /**
   * 保留两位  四舍五入
   * @param big
   * @return big
   */
  public static BigDecimal retain_2(BigDecimal big){
    big=big.setScale(2, BigDecimal.ROUND_HALF_UP);
    return big;
  }
  
  /**
   * 保留4为   四舍五入
   * @param big
   * @return
   */
  public static BigDecimal retain_4(BigDecimal big){
    big=big.setScale(4, BigDecimal.ROUND_HALF_UP);
    return big;
  }
  
  /**
   * 保留2位   四舍五入
   * @param str
   * @return
   */
  public static BigDecimal Str_To_big2(String str){
    return retain_2(new BigDecimal(str));
  }
  /**
   * 保留4位   四舍五入
   * @param str
   * @return
   */
  public static BigDecimal Str_To_big4(String str){
    return retain_4(new BigDecimal(str));
  }
  
  
  
  
}
