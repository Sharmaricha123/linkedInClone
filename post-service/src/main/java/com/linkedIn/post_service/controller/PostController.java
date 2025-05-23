package com.linkedIn.post_service.controller;

import com.linkedIn.post_service.auth.UserContextHolder;
import com.linkedIn.post_service.dto.PostCreateRequestDto;
import com.linkedIn.post_service.dto.PostDto;
import com.linkedIn.post_service.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto, HttpServletRequest httpServletRequest)
    {
        PostDto createdPost=postService.createPost(postCreateRequestDto,1L);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId,HttpServletRequest httpServletRequest)
    {
//        String userId=httpServletRequest.getHeader("X-User-Id");

        Long userId= UserContextHolder.getCurrentUserId();
        PostDto postDto=postService.getPostById(postId);
        return  ResponseEntity.ok(postDto);
    }

    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<List<PostDto>> getAllPostsOfUser(@PathVariable Long userId)
    {
        List<PostDto> posts=postService.getAllPostsOfUser(userId);
        return ResponseEntity.ok(posts);
    }
}
