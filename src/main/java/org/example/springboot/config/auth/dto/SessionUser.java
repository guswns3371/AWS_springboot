package org.example.springboot.config.auth.dto;

import lombok.Getter;
import org.example.springboot.domain.user.User;

import java.io.Serializable;

// User에 직렬화 하지 않고 따로 SessionUser 클래스를 만든 이유
// User 클래스는 엔티티이기 떄문이다 => 자식 엔티티가 생길 경우, 자식들까지 직렬화 대상이 됨 => 성능 이슈, 부수 효과 발생한다.
// 유지 보수 측면에서 직렬화 클래스를 따로 만드는게 도움 된다.
@Getter
public class SessionUser implements Serializable {
    private final String name;
    private final String email;
    private final String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
