package com.linkedIn.post_service.service;


import com.linkedIn.post_service.dto.PostCreateRequestDto;
import com.linkedIn.post_service.dto.PostDto;
import com.linkedIn.post_service.entity.Post;
import com.linkedIn.post_service.exception.ResourceNotFoundException;
import com.linkedIn.post_service.repository.PostRepositoy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private  final PostRepositoy postRepositoy;
    private  final ModelMapper modelMapper;

    public PostDto createPost(PostCreateRequestDto postCreateRequestDto,Long userId)
    {
        Post post =modelMapper.map(postCreateRequestDto,Post.class);
        post.setUserId(userId);

        Post savedPost=postRepositoy.save(post);
        return modelMapper.map(savedPost,PostDto.class);

    }


    public PostDto getPostById(Long postId) {
        log.debug("Retrieving post with ID :{}",postId);
        Post post=postRepositoy.findById(postId).orElseThrow(()->
                new ResourceNotFoundException("Post not found with id: "+postId));

        return modelMapper.map(post,PostDto.class);
    }

    public List<PostDto> getAllPostsOfUser(Long userId) {
      List<Post> posts= postRepositoy.findByUserId(userId);
    return  posts.stream().map((element)->modelMapper.map(element,PostDto.class))
              .collect(Collectors.toList());
    }
}
