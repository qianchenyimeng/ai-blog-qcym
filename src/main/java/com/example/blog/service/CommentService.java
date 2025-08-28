package com.example.blog.service;

import com.example.blog.dto.CommentDto;

public interface CommentService {
    void createComment(Long postId, CommentDto commentDto);
}
