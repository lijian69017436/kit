package exception;

import java.util.Scanner;

 

public class ExceptionTest_res2 {
  
	public static void printArrayOfInteger(String [] items){
		if(items!=null){
			if(items.length>5){
				 throw new ArrayIndexOutOfBoundsException("数组下标越界长度应<=5");	
			}else{
				for(int i=0;i<items.length;i++){
					try{
					  Integer res=Integer.parseInt(items[i]);
					  System.out.println(res);
					}catch(Exception e){
						e.printStackTrace();//控制台输出异常信息
					}	
				}
				
			}
		}
		
	}
	
	public static void sanjiao(Double a,Double b ,Double c) throws MyException{
		if(a>0&&b>0&&c>0){
			
			if(a+b>c&&c+b>a&&a+c>b){
				System.out.println("可以构成三角形");
				
			}else{
				throw new MyException("两边之和小于第三遍，不会构成三角形");
			}
			
		}else{	
			System.out.println("输入三个数据不符合格式，必须>0的数据");
		}
		
	}
	
	public static void main(String args[]){
		/*Scanner sc=new Scanner(System.in) ;
		String a1=sc.next();
		String a2=sc.next();
		String a3=sc.next();
		String a4=sc.next();
		String a5=sc.next();
		
		String [] items=new String[5];
		 
			items[0]=a1;
			items[1]=a2;
			items[2]=a3;
			items[3]=a4;
			items[4]=a5;
		ExceptionTest_res2.printArrayOfInteger(items);*/
		try {
			 
				ExceptionTest_res2.sanjiao(10.00, 40D, 100D);
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		
		
		
		
	}
	
}
