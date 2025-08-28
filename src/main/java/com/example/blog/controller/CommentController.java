package com.example.blog.controller;

import com.example.blog.dto.CommentDto;
import com.example.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public String createComment(@PathVariable("postId") Long postId,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            // How to handle errors? Redirect back to the post page with an error message?
            // For now, I'll just redirect back to the post page.
            return "redirect:/posts/" + postId;
        }
        commentService.createComment(postId, commentDto);
        return "redirect:/posts/" + postId;
    }
}
