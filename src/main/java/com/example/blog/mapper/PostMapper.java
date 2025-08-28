package com.example.blog.mapper;

import com.example.blog.dto.PostDto;
import com.example.blog.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto mapToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        postDto.setComments(post.getComments().stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList()));
        postDto.setTags(post.getTags());
        return postDto;
    }

    public static Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }
}
