package exception;

import java.util.Scanner;

 

public class ExceptionTest_res2 {
  
	public static void printArrayOfInteger(String [] items){
		if(items!=null){
			if(items.length>5){
				 throw new ArrayIndexOutOfBoundsException("�����±�Խ�糤��Ӧ<=5");	
			}else{
				for(int i=0;i<items.length;i++){
					try{
					  Integer res=Integer.parseInt(items[i]);
					  System.out.println(res);
					}catch(Exception e){
						e.printStackTrace();//����̨����쳣��Ϣ
					}	
				}
				
			}
		}
		
	}
	
	public static void sanjiao(Double a,Double b ,Double c) throws MyException{
		if(a>0&&b>0&&c>0){
			
			if(a+b>c&&c+b>a&&a+c>b){
				System.out.println("���Թ���������");
				
			}else{
				throw new MyException("����֮��С�ڵ����飬���ṹ��������");
			}
			
		}else{	
			System.out.println("�����������ݲ����ϸ�ʽ������>0������");
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
