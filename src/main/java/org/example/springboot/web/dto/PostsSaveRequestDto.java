package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    // Entity 클래스를 req/res 클래스로 사용하면 안된다!
    // Entity 클래스 (DB Layer) : DB와 맞닿은 핵심 클래스이다 : 자주 변경되면 안된다 (여러 클래스에 영향을 주기 때문)
    // req/res 용 Dto (View Layer): view를 위한 클래스로 사용된다 : 자주 변경이 필요
    // Dto 클래스 : Entity 클래스 & Controller 클래스에서 사용된다
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
