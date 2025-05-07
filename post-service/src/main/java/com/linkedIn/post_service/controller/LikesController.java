package com.linkedIn.post_service.controller;

import com.linkedIn.post_service.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesController {

    private final PostLikeService postLikeService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likePosts(@PathVariable Long postId){
        postLikeService.likePost(postId,1L);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> unlikePosts(@PathVariable Long postId){
        postLikeService.unlikePost(postId,1L);
        return  ResponseEntity.noContent().build();
    }

}
