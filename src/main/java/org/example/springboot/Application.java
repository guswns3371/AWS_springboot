package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
// Spring Boot의 자동 설정, Spring Bean 읽기 & 생성 자동 설정하는 어노테이션
// 이 어노테이션 위치부터 설정을 읽어나감 : 프로젝트 최상단에 위치해야한다

public class Application { // Application 클래스 : 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // run 메소드 : 내장 WAS를 실행하는 메소드
        // 내장 WAS : 내부에서 WAS를 실행하는것 : 항상 서버에 톰캣을 설치할 필요 없음 : Jar 피일로 실행시키면 된다
    }
}
