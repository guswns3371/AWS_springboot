package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가 어노테이션
// JPA 사용하려면 DB 데이터에 작업할 Enitiy 클래스를 수정한다
// Entity 어노테이션은 클래스의 이름을 네이밍(_)으로 테이블 이름을 정한다
// SalesManager.java => sales_manager table
@Entity
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 Primary Key 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK 생성 규칙이다. 보통 PK는 Long 타입의 auto_increment를 추천
    // GenerationType.IDENTITY 을 해야 auto_increment가 설정된다.
    private Long id;

    @Column(length = 500, nullable = false) // Column 어노테이션은 굳이 선언 하지 않아도 되고, 추가변경이 필요한 옵션이 있을때에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 생성자 대신 Builder 클래스를 사용한다
    // 기존의 생성자 : 필드의 위치를 모른다
    // Builder 어노테이션으로 제공되는 Builder 클래스를 사용 : 어느 필드에 어떤 값을 채워야 할지 명확하게 인지가능
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
