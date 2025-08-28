package com.example.blog.service.impl;

import com.example.blog.dto.CommentDto;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    void testCreateComment() {
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);

        CommentDto commentDto = new CommentDto();
        commentDto.setName("Test");
        commentDto.setEmail("test@test.com");
        commentDto.setContent("Test content");

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));

        commentService.createComment(postId, commentDto);

        verify(commentRepository).save(any(Comment.class));
    }
}
