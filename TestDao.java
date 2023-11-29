package com.oracle;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestDao extends JFrame{
	//
	SqlSessionFactory sqlMap = null;
	SqlSession session  = null;
	
	public void currentTime() {
		System.out.println("currentTime 호출");
		String time = null;
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMap = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMap.openSession();
			time = session.selectOne("currentTime");
			System.out.println(time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void procLogin1() {
		Map<String,Object> pMap = new HashMap<>();
		try {
			pMap.put("p_id", "apple");
			pMap.put("p_pw", "123");
			
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMap = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMap.openSession();		
			session.selectOne("proc_login1", pMap);
			System.out.println(pMap);
			Object keys[] = pMap.keySet().toArray();
			for(int i=0;i<keys.length;i++) {
				if("r_msg".equals(keys[i])) {
					JOptionPane.showMessageDialog(this, pMap.get("r_msg"));
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void procEmpcursor() {
		Map<String,Object> pMap = new HashMap<>();
		try {
			
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMap = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMap.openSession();
			session.selectOne("proc_empcursor", pMap);
			System.out.println(pMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		TestDao td = new TestDao();
		//td.currentTime();
		//td.procEmpcursor();
		td.procLogin1();
	}
}
