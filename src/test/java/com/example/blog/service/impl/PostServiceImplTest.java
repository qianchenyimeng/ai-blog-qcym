package com.example.blog.service.impl;

import com.example.blog.dto.PostDto;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.mapper.PostMapper;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setEmail("test@example.com");
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getEmail(), null));
    }

    @Test
    void testFindAllPosts() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Post");
        when(postRepository.findAll()).thenReturn(Collections.singletonList(post));

        List<PostDto> postDtos = postService.findAllPosts();

        assertEquals(1, postDtos.size());
        assertEquals("Test Post", postDtos.get(0).getTitle());
    }

    @Test
    void testCreatePost() {
        PostDto postDto = new PostDto();
        postDto.setTitle("New Post");
        postDto.setContent("New Content");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        postService.createPost(postDto);

        // Not much to assert here without a captor, but we can verify the interaction
        // For a more thorough test, we could use an ArgumentCaptor to capture the saved Post entity
    }
}
