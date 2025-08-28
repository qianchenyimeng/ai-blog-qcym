package com.example.blog.mapper;

import com.example.blog.dto.CommentDto;
import com.example.blog.entity.Comment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentMapperTest {

    @Test
    void testMapToCommentDto() {
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setName("John Doe");
        comment.setEmail("john.doe@example.com");
        comment.setContent("Test comment");

        CommentDto commentDto = CommentMapper.mapToCommentDto(comment);

        assertEquals(comment.getId(), commentDto.getId());
        assertEquals(comment.getName(), commentDto.getName());
        assertEquals(comment.getEmail(), commentDto.getEmail());
        assertEquals(comment.getContent(), commentDto.getContent());
    }
}
