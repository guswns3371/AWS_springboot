package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// @Repository 어노테이션이 필요 없다
// Entity 와 Repository 클래스는 함께 위치해야한다.
public interface PostsRepository extends JpaRepository<Posts,Long> {
    // extends JpaRepository<Posts,Long> 만으로 CRUD 메소드가 자동 생성된다
    // 즉 상속만으로 findAll(), deleteAll() 이런 메소드를 사용할 수 있다

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    // JpaRepository 에서 제공하지 않은 메소드는 Query로 작성해되 된다.
    List<Posts> findAllDesc();
}
