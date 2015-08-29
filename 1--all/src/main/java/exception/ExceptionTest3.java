package exception;

public class ExceptionTest3 {
    public Double mu(int i,int j) throws Exception{
    	double res=0;
    	try{
    	   res =i/j;
    	}catch(Exception e){
    		
    		throw new Exception("除法运算产生异常！"+e.getClass().getName());
    		
    	}
    	return res;
    }
    
    public Double add(double i,double j)  {
    	 
    	return i+j;
    }
    
    public static void main(String args[]){
    	
    	ExceptionTest3 test3=new ExceptionTest3();
    	System.out.println("获取两个数据的除法运算结果");
    	double res_mu=0;
    	double res_add=0;
    	try {
			res_mu=test3.mu(10, 0);
			
			System.out.println("除法运算结果："+res_mu);//如果上面一行有异常，此时该语句不执行；
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("除法运算错误！");
		}
    	
    	res_add=test3.add(20, 0);
    	System.out.println("两个数的和"+res_add);
    	
    	
    }
}
