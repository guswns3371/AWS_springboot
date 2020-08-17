package org.example.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 생성된 모든 필드의 get 메소드를 생성해주는 어노테이션
@RequiredArgsConstructor // final로 선언된 필드를 포함한 생성자를 생성해준다 : final이 없다면 생성자에 포함 안됨
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
