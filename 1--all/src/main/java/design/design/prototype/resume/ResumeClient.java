package design.design.prototype.resume;

import org.junit.Test;

/**
 * 正常 没用原型 模式 时候的    创建 对象
 * @author Administrator
 *
 */
public class ResumeClient{
  @Test
  public void Test1(){
    Resume daniao = new Resume("大鸟");
    daniao.SetPersonalInfo("男", "23");
    daniao.SetWorkExperience("1990-2001", "xx 公司");
    Resume daniao1 = new Resume("大鸟");
    daniao1.SetPersonalInfo("男", "23");
    daniao1.SetWorkExperience("1990-2001", "xx 公司");
    
    daniao.Display();
    daniao1.Display();
    
  }
}



/**
 * 简历 对象
 * @author Administrator
 *
 */
class Resume {
  String name,sex,age,timeArea,company;
  
  public Resume(String name){
    this.name=name;
  }
  public void SetPersonalInfo(String sex,String age){
    this.sex=sex;
    this.age=age;
  }
  public void SetWorkExperience(String timeArea,String company){
    this.timeArea=timeArea;
    this.company=company;
  }
  public void Display(){
    System.out.println(name+"  "+sex+"  "+age);
    System.out.println("工作经历:  "+timeArea+"  "+company);
  }
}




