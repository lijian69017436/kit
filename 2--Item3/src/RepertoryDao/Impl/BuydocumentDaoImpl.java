package RepertoryDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import RepertoryDao.inter.BuydocumentDao;
import RepertoryDao.vo.BuydocumentVo;
import Tool.Tool;
import Tool.page;

public class BuydocumentDaoImpl implements BuydocumentDao {
  private Connection conn;
  private String sql;
  private PreparedStatement  pre;
  private ResultSet res;
  private  boolean flage=false;
  
  public BuydocumentVo selectById(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="select id ,orderid,codes,providername,address,linkman,tel,times,checks,emails,fax,types  from buydocument where id=?";
    BuydocumentVo ex=new BuydocumentVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      res=pre.executeQuery();
      if(res.next()){
        ex.setId(res.getInt(1));
        ex.setOrderid(res.getString(2));
        ex.setCodes(res.getString(3));
        ex.setProvidername(res.getString(4));
        ex.setAddress(res.getString(5));
        ex.setLinkman(res.getString(6));
        ex.setTel(res.getString(7));
        ex.setTimes(res.getString(8));
        ex.setChecks(res.getString(9));
        ex.setEmails(res.getString(10));
        ex.setFax(res.getString(11));
        ex.setTypes(res.getString(12));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  public List<BuydocumentVo> queryByIdOrNames(int id ,String names) {//分页  
    conn=Tool.getToolInstance().getconn();
    if(id!=0&&names==null){
      sql="select * from buydocument where id like '%"+id+"%' ";
    }else if(id==0&&names!=null){
      sql="select * from buydocument where orderid like '%"+names+"%' ";
    }else if(id!=0&&names!=null){
      sql="select * from buydocument where orderid like '%"+names+"%' and id like'%"+id+"%' ";
    }
    List<BuydocumentVo> list=new ArrayList<BuydocumentVo>();
    try {
      PreparedStatement pre=conn.prepareStatement(sql);
      ResultSet res=pre.executeQuery();
      while(res.next()){
        BuydocumentVo ex=new BuydocumentVo();
        ex.setId(res.getInt(1));
        ex.setOrderid(res.getString(2));
        ex.setCodes(res.getString(3));
        ex.setProvidername(res.getString(4));
        ex.setAddress(res.getString(5));
        ex.setLinkman(res.getString(6));
        ex.setTel(res.getString(7));
        ex.setTimes(res.getString(8));
        ex.setChecks(res.getString(9));
        ex.setEmails(res.getString(10));
        ex.setFax(res.getString(11));
        ex.setTypes(res.getString(12));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
  
  
  
  
  
  
//分页 方法  利用 数据库limit 分页  调用工具累 page 传入 当前页 和 每页条数
  public List<BuydocumentVo> getpagelist(page page) {
    conn=Tool.getToolInstance().getconn();
    String sql="select * from buydocument limit ?,?";
    List<BuydocumentVo> list= new ArrayList<BuydocumentVo>();
    try {
      PreparedStatement prs= conn.prepareStatement(sql);
      prs.setInt(1, (page.getPageNow()-1)*page.getPageSize());//查询的开始索引 ， 当前页 -1乘以 每页条数
      prs.setInt(2, page.getPageSize());
      res=prs.executeQuery();
      while(res.next()){
        BuydocumentVo ex=new BuydocumentVo();
        ex.setId(res.getInt(1));
        ex.setOrderid(res.getString(2));
        ex.setCodes(res.getString(3));
        ex.setProvidername(res.getString(4));
        ex.setAddress(res.getString(5));
        ex.setLinkman(res.getString(6));
        ex.setTel(res.getString(7));
        ex.setTimes(res.getString(8));
        ex.setChecks(res.getString(9));
        ex.setEmails(res.getString(10));
        ex.setFax(res.getString(11));
        ex.setTypes(res.getString(12));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }

  
  
  public boolean delete(int id) {//删除方法 
    conn=Tool.getToolInstance().getconn();
    sql="delete from buydocument where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {e.printStackTrace();}
    return flage;
  }
  
  public boolean insert(BuydocumentVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="insert into buydocument (id ,orderid,codes,providername,address,linkman,tel,times,checks,emails,fax,types)" +
    		" values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, ex.getId());
      pre.setString(2, ex.getOrderid());
      pre.setString(3, ex.getCodes());
      pre.setString(4, ex.getProvidername());
      pre.setString(5, ex.getAddress());
      pre.setString(6, ex.getLinkman());
      pre.setString(7, ex.getTel());
      pre.setString(8, ex.getTimes());
      pre.setString(9, ex.getChecks());
      pre.setString(10, ex.getEmails());
      pre.setString(11, ex.getFax());
      pre.setString(12, ex.getTypes());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean update(BuydocumentVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="update buydocument set orderid=?,codes=?,providername=?,address=?,linkman=?,tel=?,times=? " +
    " ,checks=?, emails=?, fax=?, types=? where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, ex.getOrderid());
      pre.setString(2, ex.getCodes());
      pre.setString(3, ex.getProvidername());
      pre.setString(4, ex.getAddress());
      pre.setString(5, ex.getLinkman());
      pre.setString(6, ex.getTel());
      pre.setString(7, ex.getTimes());
      pre.setString(8, ex.getChecks());
      pre.setString(9, ex.getEmails());
      pre.setString(10, ex.getFax());
      pre.setString(11, ex.getTypes());
      pre.setInt(12, ex.getId());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  
  
//得到总共条数    
  public int getCount() {
    int i=0;
    conn=Tool.getToolInstance().getconn();
    try {
      Statement st= conn.createStatement();
      String sql="select count(*) from buydocument";//查询总条数
      ResultSet  rs= st.executeQuery(sql);
      if(rs.next()){
        i=rs.getInt(1);//得到 多少条数据
      }
    } catch (SQLException e) {e.printStackTrace();}
    return i;
  }
  
  
}
