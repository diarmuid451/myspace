package com.jsp.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OracleMyBatisSqlSessionFactoryBuilder {

	private OracleMyBatisSqlSessionFactoryBuilder() {}
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String config = "com/jsp/mybatis/sqlConfig.xml"; 
				
		try {
			Reader reader = Resources.getResourceAsReader(config);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			System.out.println("sqlSessionFactory 성공했습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("sqlSessionFactory 실패했습니다.");
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
