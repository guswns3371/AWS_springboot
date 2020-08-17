package org.example.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.Posts;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.PostsListResponseDto;
import org.example.springboot.web.dto.PostsResponseDto;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// 스프링에서 Bean을 주입받는 방식 3가지 : @Autowired, setter, 생성자 <= 생성자로 주입 받는게 가장 권장됨
// RequiredArgsConstructor 어노테이션으로 final로 선언된 필드를 인자 값으로 하는 생성자를 만들어준다
// 클래스의 의존성 관계가 변경될때 => RequiredArgsConstructor 어노테이션으로 생성자를 따로 변경할 필요 없다
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다, id="+id));

        postsRepository.delete(posts);
        // 엔티티를 파라미터로 삭제 가능, deleteById 메소드로는 id로 삭제 가능
        // 존재하는 Posts인지 확인을 위해서 먼저 조회한 뒤에 (findById) , delete한다
    }
}
