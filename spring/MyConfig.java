package com.example.demo.di2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml 문서 대신 자바 클래스를 통해 필요한 객체를 미리 등록함
//이렇게 함으ㄹ써 이른 객체 생성 - 서비스를 위해 필요한 클래스 설계는 개발자의 몫이므로
//즉 설계자에 따라 클래스의 이름이 다 달라져야 한다.
//@Configuration을 붙여서 필요한 객체를 미리 선언해 두기
//이때 함께 사용할 어노테이션이 bean 어노테이션
@Configuration
public class MyConfig {
    @Bean
    public testController testController() {//class와 bean은 같은 의미라 생각해도 좋다
        //메소드를 통해 객체를 주입 - 권장
        return new testController();
    }

    @Bean
    public testLogic testLogic() {//메소드로 객체 주입
      //이른 객체 주입이 중요하다옹
        return new testLogic();
    }

    @Bean
    public testDao testDao() {
        return new testDao();
    }
}
