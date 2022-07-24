package com.knitmarket.api.service;

import com.knitmarket.api.domain.Post;
import com.knitmarket.api.repository.PostRepository;
import com.knitmarket.api.request.PostCreate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private  PostService postService;

    @Autowired
    private PostRepository postRepository;


    @Test
    @DisplayName("글작성")
    void test1(){
        //given
        PostCreate postCreate = PostCreate.builder()
                .title("제목입니다")
                .content("내용입니다")
                .build();


        //when
        postService.write(postCreate);

        //then
        assertEquals(1L,postRepository.count());
        Post post = postRepository.findAll().get(0);
        assertEquals("제목입니다",post.getTitle());
        assertEquals("내용입니다",post.getContent());

    }

    @Test
    @DisplayName("글 1개 조회")
    void test2(){
        //given
        Long postId = 1L;

        //when
         Post post= postService.get(postId);

         //then
        Assertions.assertNotNull(post);


    }



}