package exception;

public class ExceptionTest2 {
    public Boolean setAgeArrea(int age) throws Exception{
    	boolean flag=false;
    	if(age>18&&age<=100){
    		
    		flag=true;
    	}else{ 
			throw new Exception("年龄不符合18-100之间");
    	}
    	System.out.println("********");
    	return flag;
    }
    
    public static void main(String args[]){
    	ExceptionTest2 test=new ExceptionTest2();
    	Boolean b=null;
		try {
			b = test.setAgeArrea(6);
			System.out.println(b);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("只有这里执行相关操作：finally语句段");
			
		}
		System.out.println("----");
    	
    }
    
}
