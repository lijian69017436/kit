package db.hibernate.one.pk_created.tool;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateTable {
	/**
	 * 将映射文件中的内容，生成数据库端对应的标结构
	 * @param args
	 */
	public static void main(String[] args) {
		//读取hibernate配置文件
		Configuration cfg=	HibernateSessionFactory.getConfiguration();
		
		//工具利用实体类（vo类，持久化类）和映射文件生成数据库端的表结构
		SchemaExport export=new SchemaExport(cfg);
		/*
		 * 第一个参数：把DDL语句输出到控制台上
		 * 的二个参数：根据实体类（vo类，持久化类）和映射文件生成数据库端的表结构
		 */
		export.create(true, true);
	}
}
