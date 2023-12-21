package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service << 가능하지만 권장하지 않음
@Repository
public class NoticeDao {
    Logger logger = LoggerFactory.getLogger(NoticeDao.class);

    @Autowired
    SqlSessionTemplate sqlsessionTemplate = null;// SqlSession - myBatis.jar 에서 가져왔으므로. 현재: myBatis-spring.jar(역할은 같지만
                                                 // 이름은 다르게.)

    public List<Map<String, Object>> noticeList(Map<String, Object> pmap) {
        logger.info("noticeList");
        List<Map<String, Object>> list = sqlsessionTemplate.selectList("com.example.demo.dao.NoticeDao.noticeList",
                pmap);
        logger.info(list.toString());
        return list;
    }

    public List<Map<String, Object>> noticeInsert(Map<String, Object> pmap) {
        logger.info("noticeInsert");
        // 새로운 공지사항을 데이터베이스에 추가
        sqlsessionTemplate.insert("com.example.demo.dao.NoticeDao.noticeInsert", pmap);

        // 변경된 리스트를 가져오기 위해 noticeList 쿼리를 다시 실행
        List<Map<String, Object>> list = sqlsessionTemplate.selectList("com.example.demo.dao.NoticeDao.noticeList",
                pmap);

        logger.info(list.toString());
        return list;
    }
  //Insert까지 함

}
