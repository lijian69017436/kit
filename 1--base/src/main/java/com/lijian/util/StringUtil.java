package com.lijian.util;

public class StringUtil {

	  /**
	   * 
	   * @param str
	   * @return true 空   false 非空
	   */
	  public static boolean isNull(Object str){
	    // isEmpty() 为空  返回true
	    if("".equals(str)|| null==str ){
	      return true;
	    }else{
	      return false;
	    }
	  }
}
