package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest1 {
    public Date getNowDate(String str) throws ParseException ,ArithmeticException{//throws 在方法声明时使用，表示抛出可能产生的异常；
    	//如果throws 抛出多种异常，此时用，号隔开；只有非运行时异常，抛出以后必须手动捕获或者throws
    	Date day=new Date();
    	SimpleDateFormat simpleFormat=new SimpleDateFormat("yyyy-MM-dd");
    	day=simpleFormat.parse(str);//此时throws 将ParseException异常抛出，并不捕获处理；
    	return day;
    }
    
    public void test() {
    	Date day=null;
			try {
				day = this.getNowDate("2014-10/10");
				System.out.println("++++++++++++++++");
				
			}catch(ArithmeticException e){
				//try来捕获，catch处理指定类型的异常
				e.printStackTrace();//用于控制台输出异常信息；	
			}
			catch (ParseException e) {
				
				e.printStackTrace();
			}
		 
		
    	SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
    	System.out.println(format.format(day));
    }
    
    public static void main(String args[]){
    	ExceptionTest1 test=new ExceptionTest1();
    	
	    test.test();//try中程序表示要捕获异常的相关程序；
			
		
    	
    }
	
}
