package OrderDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import OrderDao.inter.ExportClientDao;
import OrderDao.vo.ExportClientVo;
import Tool.Tool;
import Tool.page;

public class ExportClientDaoImpl implements ExportClientDao {
  private Connection conn;
  private String sql;
  private PreparedStatement  pre;
  private ResultSet res;
  private  boolean flage=false;
  
  public ExportClientVo selectById(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="select id ,clientnumber,clientaddress,tel,dates,names,fax,sales,linkman  from exportclient where id=?";
    ExportClientVo ex=new ExportClientVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      res=pre.executeQuery();
      if(res.next()){
        ex.setId(res.getInt(1));
        ex.setClientnumber(res.getString(2));
        ex.setClientaddress(res.getString(3));
        ex.setTel(res.getString(4));
        ex.setDates(res.getString(5));
        ex.setNames(res.getString(6));
        ex.setFax(res.getString(7));
        ex.setSales(res.getString(8));
        ex.setLinkman(res.getString(9));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  public List<ExportClientVo> queryByIdOrNames(int id ,String names) {//分页  
    conn=Tool.getToolInstance().getconn();
    if(id!=0&&names==null){
      sql="select * from exportclient where id like '%"+id+"%' ";
    }else if(id==0&&names!=null){
      sql="select * from exportclient where names like '%"+names+"%' ";
    }else if(id!=0&&names!=null){
      sql="select * from exportclient where names like '%"+names+"%' and id like'%"+id+"%' ";
    }
    List<ExportClientVo> list=new ArrayList<ExportClientVo>();
    try {
      PreparedStatement pre=conn.prepareStatement(sql);
      ResultSet res=pre.executeQuery();
      while(res.next()){
        ExportClientVo ex=new ExportClientVo();
        ex.setId(res.getInt(1));
        ex.setClientnumber(res.getString(2));
        ex.setClientaddress(res.getString(3));
        ex.setTel(res.getString(4));
        ex.setDates(res.getString(5));
        ex.setNames(res.getString(6));
        ex.setFax(res.getString(7));
        ex.setSales(res.getString(8));
        ex.setLinkman(res.getString(9));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
  
  
  
  
  
  
//分页 方法  利用 数据库limit 分页  调用工具累 page 传入 当前页 和 每页条数
  public List<ExportClientVo> getpagelist(page page) {
    conn=Tool.getToolInstance().getconn();
    String sql="select * from exportclient limit ?,?";
    List<ExportClientVo> list= new ArrayList<ExportClientVo>();
    try {
      PreparedStatement prs= conn.prepareStatement(sql);
      prs.setInt(1, (page.getPageNow()-1)*page.getPageSize());//查询的开始索引 ， 当前页 -1乘以 每页条数
      prs.setInt(2, page.getPageSize());
      res=prs.executeQuery();
      while(res.next()){
        ExportClientVo ex=new ExportClientVo();
        ex.setId(res.getInt(1));
        ex.setClientnumber(res.getString(2));
        ex.setClientaddress(res.getString(3));
        ex.setTel(res.getString(4));
        ex.setDates(res.getString(5));
        ex.setNames(res.getString(6));
        ex.setFax(res.getString(7));
        ex.setSales(res.getString(8));
        ex.setLinkman(res.getString(9));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
//得到总共条数    
  public int getCount() {
    int i=0;
    conn=Tool.getToolInstance().getconn();
    try {
      Statement st= conn.createStatement();
      String sql="select count(*) from exportclient";//查询总条数
      ResultSet  rs= st.executeQuery(sql);
      if(rs.next()){
        i=rs.getInt(1);//得到 多少条数据
      }
    } catch (SQLException e) {e.printStackTrace();}
    return i;
  }
  
  
  public boolean delete(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="delete from exportclient where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean insert(ExportClientVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="insert into exportclient (id ,clientnumber,clientaddress,tel,dates,names,fax,sales,linkman)" +
    		" values(?,?,?,?,?,?,?,?,?)";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, ex.getId());
      pre.setString(2, ex.getClientnumber());
      pre.setString(3, ex.getClientaddress());
      pre.setString(4, ex.getTel());
      pre.setString(5, ex.getDates());
      pre.setString(6, ex.getNames());
      pre.setString(7, ex.getFax());
      pre.setString(8, ex.getSales());
      pre.setString(9, ex.getLinkman());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean update(ExportClientVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="update exportclient set clientnumber=?,clientaddress=?,tel=?,dates=?,names=?,fax=?,sales=?,linkman=? " +
    " where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, ex.getClientnumber());
      pre.setString(2, ex.getClientaddress());
      pre.setString(3, ex.getTel());
      pre.setString(4, ex.getDates());
      pre.setString(5, ex.getNames());
      pre.setString(6, ex.getFax());
      pre.setString(7, ex.getSales());
      pre.setString(8, ex.getLinkman());
      pre.setInt(9, ex.getId());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
}
