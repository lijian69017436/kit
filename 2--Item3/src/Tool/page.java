package Tool;

public class page {


  private int count ;//总条数
  private int pageNow;//当前页
  private int pageSize=3;//每页显示的最大 条数
  private int pageCount;//总页数
  
  
//  private int firstPage=1;//最前一页 
//  private int lastPage;//最后页
//  private int uperPage;
//  private int nextPage;
  
  public int getPageNow() {
    if(this.pageNow>this.getPageCount()){
      pageNow=this.getPageCount();
    }
    return pageNow;
  }
  public int getPageCount() {//求总页数 
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