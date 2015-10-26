package design.design.template.paper;

import org.junit.Test;

/**
 * 模板方法  模式   的 考试试卷
 * @author Administrator
 *
 */
public class Paper {
  @Test
  public void TestClient(){
    System.out.println("学生甲抄的试卷:");
    IPaper PapA = new PaperA();
    PapA.TestQuestion1();
    PapA.TestQuestion2();
    PapA.TestQuestion3();
    
    System.out.println("学生已抄的试卷:");
    IPaper ap = new PaperB();
    ap.TestQuestion1();
    ap.TestQuestion2();
    ap.TestQuestion3();
  }
}

/**模板
 * 算法结构  
 * @author Administrator
 *
 */
class IPaper{
  public void TestQuestion1(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : "+Answer1());
  }
  public void TestQuestion2(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : "+Answer2());
  }
  public void TestQuestion3(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : "+Answer3());
  }
  protected String Answer1(){
    return "";
  }
  protected String Answer2(){
    return "";
  }
  protected String Answer3(){
    return "";
  }
}

/**
 * 重订义 算法 特定步骤
 * @author Administrator
 *
 */
class PaperB extends IPaper{
  @Override
  protected String Answer1() {
    // TODO Auto-generated method stub
    return "a";
  }
  @Override
  protected String Answer2() {
    // TODO Auto-generated method stub
    return "c";
  }
  @Override
  protected String Answer3() {
    // TODO Auto-generated method stub
    return "d";
  }
}
class PaperA extends IPaper{
  @Override
  protected String Answer1() {
    // TODO Auto-generated method stub
    return "c";
  }
  @Override
  protected String Answer2() {
    // TODO Auto-generated method stub
    return "d";
  }
  @Override
  protected String Answer3() {
    // TODO Auto-generated method stub
    return "b";
  }
}


