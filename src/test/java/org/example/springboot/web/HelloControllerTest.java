package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다
@WebMvcTest(controllers = HelloController.class)
// Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입 받는다
    private MockMvc mvc; // HTTP GET POST 등에 대한 API 테스트를 할 수 있다

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(MockMvcRequestBuilders.get("/hello")) // /hello 주소로 GET 요청을 한다
                .andExpect(status().isOk()) // perform의 결과를 검증 : status의 상태를 검증 : ok(200)인지 검증
                .andExpect(content().string(hello)); // perform의 결과 검증 : "hello"를 리턴하는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
