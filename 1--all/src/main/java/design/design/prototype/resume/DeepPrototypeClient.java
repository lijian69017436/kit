package design.design.prototype.resume;

import org.junit.Test;

public class DeepPrototypeClient {
  @Test
  public void Test1() throws CloneNotSupportedException{
    IResume iRes = new IResume("大鸟");
    iRes.SetWorkExperience("1990", "大连工作");
    IResume ir=(IResume)iRes.clone();
    ir.SetWorkExperience("2000", "海淀");
    IResume ire=(IResume)iRes.clone();
    iRes.Display();
    ir.Display();
    ire.Display();
    
  }
  
  
}


class IResume implements Cloneable{
  String name,sex,age,timeArea,company;
  WorkExperience workEx;
  public IResume(String name){
    this.name=name;
    workEx=new WorkExperience();
  }
  public void SetPersonalInfo(String sex,String age){
    this.sex=sex;
    this.age=age;
  }
  public void SetWorkExperience(String timeArea,String company){
    workEx.setWorkDate(timeArea);
    workEx.setCompany(company);
  }
  public void Display(){
    System.out.println(name+"  "+sex+"  "+age);
    System.out.println("工作经历:  "+workEx.getWorkDate()+"  "+workEx.getCompany());
  }
  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
  }
}

class WorkExperience {
  String workDate ,company;

  public String getWorkDate() {
    return workDate;
  }
  public void setWorkDate(String workDate) {
    this.workDate = workDate;
  }
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }
}