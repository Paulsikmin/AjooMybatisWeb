package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 공장만드는 기술자임
			SqlSessionFactory factory = builder.build(is); // 공장만들어짐, 공장만들때 xml파일 참조해서 만듬
			session = factory.openSession(); // 공장에서 연결만들어줌. 내가 이걸 원한거임.
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;	// 리턴 때려주면 됨. 필요한대서 가져다가 쓸 수 있음.
	}
}
