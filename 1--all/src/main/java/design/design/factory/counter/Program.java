package design.design.factory.counter;

import java.util.Scanner;

import org.junit.Test;

/**
 * 这个类介绍的 : 是面向对象 工厂模式演变的过程   
 */
public class Program { 
  @Test
  public void progarm() { //最简单的 计算器  面向过程的
    Scanner sc = new Scanner(System.in);  
    System.out.print("请输入数字A:");
    String a=sc.next();
    System.out.print("请输入运算符号(+-*/):");
    String c=sc.next();
    System.out.print("请输入数字b:");
    String b=sc.next();
    String d="";
    if(c.equals("+")){
      d=(Integer.valueOf(a)+Integer.valueOf(b))+"";
    }
    if(c.equals("-")){
      d=(Integer.valueOf(a)-Integer.valueOf(b))+"";
    }
    if(c.equals("*")){
      d=(Integer.valueOf(a)*Integer.valueOf(b))+"";
    }
    if(c.equals("/")){
      d=(Integer.valueOf(a)/Integer.valueOf(b))+"";
    }
    System.out.println(d);
  }
  @Test
  public void progarm1() { //最简单的 计算器  优化命名等
    Scanner sc = new Scanner(System.in);  
    System.out.print("请输入数字A:");
    String stra=sc.next();
    System.out.print("请输入运算符号(+-*/):");
    String strc=sc.next();
    System.out.print("请输入数字b:");
    String strb=sc.next();
    String result="";
    switch (strc) {
      case "+" :
        result=(Integer.valueOf(stra)+Integer.valueOf(strb))+"";
        break;
      case "-" :
        result=(Integer.valueOf(stra)-Integer.valueOf(strb))+"";
        break;
      case "*" :
        result=(Integer.valueOf(stra)*Integer.valueOf(strb))+"";
        break;
      case "/" :
        if(!strb.equals("0"))
          result=(Integer.valueOf(stra)/Integer.valueOf(strb))+"";
        break;
      default :
        result="运算符输入错误";
        break;
    }
    System.out.println(result);
  }
  
  @Test
  public void progarm2() { //最简单的 计算器  简单的 面向对象的  业务 和页面分离
    Scanner sc = new Scanner(System.in);  
    System.out.print("请输入数字A:");
    String stra=sc.next();
    System.out.print("请输入运算符号(+-*/):");
    String strc=sc.next();
    System.out.print("请输入数字b:");
    String strb=sc.next();
    double result=count.getResult(Double.valueOf(stra), Double.valueOf(strb), strc);
    System.out.println(result+"");
  }
  
}
class count{
  public static double getResult(double inputa, double inputb ,String inputCount){
    double result=0;
    switch (inputCount) {
      case "+" :
        result=(inputa)+inputb;
        break;
      case "-" :
        result=(inputa)-inputb;
        break;
      case "*" :
        result=(inputa)*inputb;
        break;
      case "/" :
        if(inputb!=0)
          result=(inputa)/inputb;
        break;
    }
    return result;
  }
}

