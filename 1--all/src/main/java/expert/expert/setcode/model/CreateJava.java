package expert.expert.setcode.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import common.li.Config;
import common.li.FileTool;
import expert.expert.setcode.MainMethod;

public abstract class CreateJava {
  protected StringBuffer sb=new StringBuffer();
  protected String str=new String();
  protected  Properties pro= Config.ini(MainMethod.class);
  protected  String iurl=pro.getProperty("itemurl");
  protected  String purl=pro.getProperty("packageurl");
  protected  String bean=pro.getProperty("bean");
  protected  String pagination=pro.getProperty("pagination");
  protected  String importurl= purl.replace("//", ".");
  
  public abstract void CreateJava() throws IOException, URISyntaxException;
}


class CreateDao extends CreateJava {

  @Override
  public void CreateJava() throws IOException, URISyntaxException {
    // TODO Auto-generated method stub
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
  }
}

class CreateBean extends CreateJava{

  @Override
  public void CreateJava() throws IOException, URISyntaxException {
  //---------------------bean -------
    sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"bean.txt");
    str=sb.toString();
    str= str.replace("0--",importurl+"bean");
    str= str.replace("1--", bean);
    FileTool.writesStringByNIO(iurl+purl+"bean//", bean+".java",str,"utf-8");
  }
}


class CreateService extends CreateJava{

  @Override
  public void CreateJava() throws IOException, URISyntaxException {
    //----------------------service-------
    sb.setLength(0);
    str="";
    sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"service.txt");
    str=sb.toString();
    str= str.replace("1--", bean);
    str= str.replace("0--", importurl+"service");
    str= str.replace("3--", importurl+"bean"+"."+bean);
    str= str.replace("4--", pagination);
    FileTool.writesStringByNIO(iurl+purl+"service//", bean+"Service"+".java",str,"utf-8");
    //----------------------serviceimpl-------
    sb.setLength(0);
    str="";
    sb=FileTool.readTargetFileText(ModelCode.class.getResource("").toURI().getPath()+"serviceimpl.txt");
    str=sb.toString();
    str= str.replace("1--", bean);
    str= str.replace("0--", importurl+"service.impl");
    str= str.replace("3--", importurl+"bean"+"."+bean);
    str= str.replace("4--", pagination);
    str= str.replace("5--", importurl+"service."+bean+"Service");
    str= str.replace("6--", importurl+"dao."+bean+"Dao");
    FileTool.writesStringByNIO(iurl+purl+"service//impl//", bean+"ServiceImpl"+".java",str,"utf-8");
  }
  
}