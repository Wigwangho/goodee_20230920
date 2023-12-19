package com.example.demo.di2;

import java.util.*;

import org.springframework.context.annotation.Bean;

import java.lang.reflect.*;
import java.lang.annotation.Annotation;

public class MyContext {
    Map<String, Object> map = new HashMap<>();

    public MyContext() {
        map.put("testController", new testController());
        map.put("testLogic", new testLogic());
        map.put("testDao", new testDao());
    }

    @SuppressWarnings("deprecation")
    public MyContext(Class<?> clazz) {// 파라미터 자리 - MyConfig - @Configuration - 스캔 - @Bean 등록
        try {
            Object myConfig = clazz.newInstance();
            for (Method m : clazz.getDeclaredMethods()) {
                for (Annotation ann : m.getDeclaredAnnotations()) {
                    if (ann.annotationType() == Bean.class) {// 객체를 생성
                        // 메소드 이름(testController, testLogic, testDao)을 키값으로 하여 값을 생성함
                        map.put(m.getName(), m.invoke(myConfig, null));
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    Object getBean(Class<testController> clazz) {// 클래스 명으로 객체 찾기
        return map.get(clazz);
    }

    Object getBean(String id) {// 이름으로 객체 찾기
        return map.get(id);
    }
}
