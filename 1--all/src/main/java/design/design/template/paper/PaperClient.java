package design.design.template.paper;

import org.junit.Test;

/**
 * 最基础的 考试试卷
 * @author Administrator
 *
 */
public class PaperClient {
  @Test
  public void TestClient(){
    System.out.println("学生甲抄的试卷:");
    TestPaperA PapA = new TestPaperA();
    PapA.TestQuestion1();
    PapA.TestQuestion2();
    PapA.TestQuestion3();
    
    System.out.println("学生已抄的试卷:");
    TestPaperB ap = new TestPaperB();
    ap.TestQuestion1();
    ap.TestQuestion2();
    ap.TestQuestion3();
    
  }
}


class TestPaperA{
  public void TestQuestion1(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : b");
  }
  public void TestQuestion2(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : c");
  }
  public void TestQuestion3(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : a");
  }
}
class TestPaperB{
  public void TestQuestion1(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : b");
  }
  public void TestQuestion2(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : c");
  }
  public void TestQuestion3(){
    System.out.println("杨过得到,后来给了郭靖,连城倚天剑,什么材料 () a,碳素   b,马口铁  c,告诉合金  d,前卫刚");
    System.out.println("答案   : a");
  }
}


