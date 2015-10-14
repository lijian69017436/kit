package design.design.factory.counter;

import java.util.Scanner;

import org.junit.Test;

/***
 * @介绍 : 这个类 是一个简单工厂的 实现 
 * */
public class Factory { //简单工厂模式    传入参数返回创建的对象
  @Test
  public void test(){ //客户端 
    Scanner sc = new Scanner(System.in);  
    System.out.print("请输入数字A:");
    String stra=sc.next();
    System.out.print("请输入运算符号(+-*/):");
    String strc=sc.next();
    System.out.print("请输入数字b:");
    String strb=sc.next();
    
    
    Operation oper;
    oper=new OperationFactory().createOperation(strc);//工厂类 :根据 需求 创建相对应的对象
    oper.doubleA=Integer.valueOf(stra);
    oper.doubleB=Integer.valueOf(strb);
    System.out.println(oper.getResult()); 
  }
  
} 

class Operation{//操作类  (业务对象)  
  double doubleA=0d;
  double doubleB=0d;
  double result=0d;
  public double getResult(){
    double result=0d;
    return result;
  }
}


 
class OperationFactory{   //工厂创建对象 
   Operation oper;
  public  Operation createOperation(String operator){
    switch (operator) {
      case "+" :
        oper=new OperationAdd();
        break;
      case "-" :
        oper=new OperationCut();
        break;
      case "*" :
        oper=new OperationRide();
        break;
      case "/" :
        oper=new OperationDivide();
        break;
      default :
        oper=new Operation();
        break;
    }  
    return oper;
  }
}


class OperationAdd extends Operation  { //业务对象的具体实现
  @Override
  public double getResult() {
    result=doubleA +doubleB;
    return result;
  }
}
class OperationCut extends Operation  {
  @Override
  public double getResult() {
    result=doubleA -doubleB;
    return result;
  }
}
class OperationRide extends Operation  {
  @Override
  public double getResult() {
    result=doubleA *doubleB;
    return result;
  }
}
class OperationDivide extends Operation  {
  @Override
  public double getResult() {
    result=doubleA /doubleB;
    return result;
  }
}