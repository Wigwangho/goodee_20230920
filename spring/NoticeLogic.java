package com.example.demo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; // 추가

import com.example.demo.dao.NoticeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component // 추가: Spring이 이 클래스를 빈으로 관리할 수 있도록 함
public class NoticeLogic {
    Logger logger = LoggerFactory.getLogger(NoticeLogic.class);

    @Autowired//DI - 의존성 주입
  //자동으로 의존성을 주입해 주는 어노테이션
    NoticeDao noticeDao = null;

    public List<Map<String, Object>> noticeList(Map<String, Object> pmap) { // 메소드 이름 오타 수정: noticeLIst -> noticeList
        logger.info("noticeLink");
        List<Map<String, Object>> list = new ArrayList<>();
        list = noticeDao.noticeList(pmap);
        return list;
    }
}
