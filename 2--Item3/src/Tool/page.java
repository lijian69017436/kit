package Tool;

public class page {


  private int count ;//������
  private int pageNow;//��ǰҳ
  private int pageSize=3;//ÿҳ��ʾ����� ����
  private int pageCount;//��ҳ��
  
  
//  private int firstPage=1;//��ǰһҳ 
//  private int lastPage;//���ҳ
//  private int uperPage;
//  private int nextPage;
  
  public int getPageNow() {
    if(this.pageNow>this.getPageCount()){
      pageNow=this.getPageCount();
    }
    return pageNow;
  }
  public int getPageCount() {//����ҳ�� 
    int i=0;
    if(this.count%this.pageSize==0){
      i=(this.count/this.pageSize);
    }else{
      i=(this.count/this.pageSize)+1;
      
    }
    return i;
  }
  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
 
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
 
  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }
  public void setPageNow(int pageNow) {
    this.pageNow = pageNow;
  }
}