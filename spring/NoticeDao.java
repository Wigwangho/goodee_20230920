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
@Repository //대부분의 경우, @Repository 어노테이션은 DAO 클래스에 사용되며, 해당 클래스는 데이터베이스 액세스와 관련된 작업을 수행합니다. 이를 통해 Spring이 해당 클래스를 빈으로 인식하고 관리하게 됩니다. by ChatGPT
public class NoticeDao {
    Logger logger = LoggerFactory.getLogger(NoticeDao.class);

    @Autowired
    SqlSessionTemplate sqlsessionTemplate = null;// SqlSession - myBatis.jar 에서 가져왔으므로. 현재: myBatis-spring.jar(역할은 같지만
                                                 // 이름은 다르게.)

    public List<Map<String, Object>> noticeList(Map<String, Object> pmap) {
        logger.info("noticeList");
        List<Map<String, Object>> list = sqlsessionTemplate.selectList("noticeList");
        logger.info(list.toString());
        return null;
    }

}
