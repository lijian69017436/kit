package exception;

public class ExceptionTest3 {
    public Double mu(int i,int j) throws Exception{
    	double res=0;
    	try{
    	   res =i/j;
    	}catch(Exception e){
    		
    		throw new Exception("������������쳣��"+e.getClass().getName());
    		
    	}
    	return res;
    }
    
    public Double add(double i,double j)  {
    	 
    	return i+j;
    }
    
    public static void main(String args[]){
    	
    	ExceptionTest3 test3=new ExceptionTest3();
    	System.out.println("��ȡ�������ݵĳ���������");
    	double res_mu=0;
    	double res_add=0;
    	try {
			res_mu=test3.mu(10, 0);
			
			System.out.println("������������"+res_mu);//�������һ�����쳣����ʱ����䲻ִ�У�
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����������");
		}
    	
    	res_add=test3.add(20, 0);
    	System.out.println("�������ĺ�"+res_add);
    	
    	
    }
}
