package expert.expert.setcode;


import java.util.Properties;

import common.li.Config;
import common.li.FileTool;
import expert.expert.setcode.model.ModelCode;

public class MainMethod {
  
  public static void main(String[] args) {
    StringBuffer sb=new StringBuffer();
    String str=new String();
    
    Properties pro= Config.ini(MainMethod.class);
    String iurl=pro.getProperty("itemurl");
    String purl=pro.getProperty("packageurl");
    String bean=pro.getProperty("bean");
    String importurl= purl.replace("//", ".");
    try{
      //---------------------bean -------
      sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"bean.txt");
      str=sb.toString();
      str= str.replace("0--",importurl+"bean");
      str= str.replace("1--", bean);
      FileTool.writesStringByNIO(iurl+purl+"bean//", bean+".java",str,"utf-8");
      //----------------------dao---------
      sb.setLength(0);
      str="";
      sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"dao.txt");
      str=sb.toString();
      str= str.replace("0--", importurl+"dao");
      str= str.replace("1--", bean+"Dao");
      str= str.replace("2--", bean);
      str= str.replace("3--", purl.replace("//", ".")+"bean"+"."+bean);
      FileTool.writesStringByNIO(iurl+purl+"dao//", bean+"Dao"+".java",str,"utf-8");
      //----------------------daoimpl-------
      sb.setLength(0);
      str="";
      sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"daoImpl.xml");
      str=sb.toString();
      str= str.replace("importDao--", importurl+"dao."+bean+"Dao");
      str= str.replace("importBean--", importurl+"bean"+"."+bean);
      str= str.replace("0---", bean);
      FileTool.writesStringByNIO(iurl+purl+"dao//impl//", bean+"DaoImpl"+".xml",str,"utf-8");
      
      //----------------------service-------
      sb.setLength(0);
      str="";
      sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"service.txt");
      str=sb.toString();
      str= str.replace("1--", bean);
      str= str.replace("0--", importurl+"service");
      str= str.replace("3--", importurl+"bean"+"."+bean);
      str= str.replace("4--", pro.getProperty("pagination"));
      FileTool.writesStringByNIO(iurl+purl+"service//", bean+"Service"+".java",str,"utf-8");
      //----------------------serviceimpl-------
      sb.setLength(0);
      str="";
      sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"serviceimpl.txt");
      str=sb.toString();
      str= str.replace("1--", bean);
      str= str.replace("0--", importurl+"service.impl");
      str= str.replace("3--", importurl+"bean"+"."+bean);
      str= str.replace("4--", pro.getProperty("pagination"));
      str= str.replace("5--", importurl+"service."+bean+"Service");
      str= str.replace("6--", importurl+"dao."+bean+"Dao");
      FileTool.writesStringByNIO(iurl+purl+"service//impl//", bean+"ServiceImpl"+".java",str,"utf-8");
      
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
