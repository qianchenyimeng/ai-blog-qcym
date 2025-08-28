package com.example.blog.mapper;

import com.example.blog.dto.PostDto;
import com.example.blog.entity.Post;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostMapperTest {

    @Test
    void testMapToPostDto() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setContent("Test Content");

        PostDto postDto = PostMapper.mapToPostDto(post);

        assertEquals(post.getId(), postDto.getId());
        assertEquals(post.getTitle(), postDto.getTitle());
        assertEquals(post.getContent(), postDto.getContent());
    }
}
