package com.example.blog.service;

import com.example.blog.dto.PostDto;
import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    void createPost(PostDto postDto);

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

    void deletePost(Long postId);

    List<PostDto> searchPosts(String query);

    List<PostDto> findPostsByTag(String tagName);
}
