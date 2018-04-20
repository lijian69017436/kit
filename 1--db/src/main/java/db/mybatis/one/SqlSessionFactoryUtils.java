package db.mybatis.one;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {
	 static SqlSession sqlSession=null;
	 static SqlSessionFactory sqlSessionFactory = null;
		static{//这里我用了静态初始化块，来获取mybatis的xml文件，从而获取连接。
			try {
				 Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
				   sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
				   sqlSession=  sqlSessionFactory.openSession();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				sqlSession.close();
			} 
				
		}
    public static  SqlSession  getSqlSession(){	 
    	return sqlSession;
    }
}
