package com.example.demo.pojo1;
//pure - 다른 디바이스에서도 잘 작동되면 좋겠어
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.util.MyBatisCommonFactory;

public class NoticeLogic {
	Logger logger = LoggerFactory.getLogger(NoticeLogic.class);
	SqlSessionFactory sqlSessionFactory = null;
	
	public List<Map<String,Object>> noticeList(){
		List<Map<String, Object>> nList = new ArrayList<>();
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			nList = sqlSession.selectList("noticeList");
			logger.info(nList.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return nList;
	}
	public int noticeInsert(){
		logger.info("noticeInsert");
		int result = 0;
		
		
		return result;
	}
	public int noticeDelete(){
		logger.info("noticeDelete");
		int result = 0;
		return result;
	}
	
	public int noticeUpdate(){
		logger.info("noticeUpdate");
		int result = 0;
		return result;
	}
}
