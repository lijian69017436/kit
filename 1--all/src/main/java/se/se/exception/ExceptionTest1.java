package se.se.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest1 {
    public Date getNowDate(String str) throws ParseException ,ArithmeticException{//throws �ڷ�������ʱʹ�ã���ʾ�׳����ܲ�����쳣��
    	//���throws �׳������쳣����ʱ�ã��Ÿ�����ֻ�з�����ʱ�쳣���׳��Ժ�����ֶ��������throws
    	Date day=new Date();
    	SimpleDateFormat simpleFormat=new SimpleDateFormat("yyyy-MM-dd");
    	day=simpleFormat.parse(str);//��ʱthrows ��ParseException�쳣�׳������������?
    	return day;
    }
    
    public void test() {
    	Date day=null;
			try {
				day = this.getNowDate("2014-10/10");
				System.out.println("++++++++++++++++");
				
			}catch(ArithmeticException e){
				//try������catch����ָ�����͵��쳣
				e.printStackTrace();//���ڿ���̨����쳣��Ϣ��	
			}
			catch (ParseException e) {
				
				e.printStackTrace();
			}
		 
		
    	SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
    	System.out.println(format.format(day));
    }
    
    public static void main(String args[]){
    	ExceptionTest1 test=new ExceptionTest1();
    	
	    test.test();//try�г����ʾҪ�����쳣����س���
			
		
    	
    }
	
}
