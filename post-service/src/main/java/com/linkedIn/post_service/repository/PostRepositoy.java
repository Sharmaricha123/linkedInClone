package com.linkedIn.post_service.repository;

import com.linkedIn.post_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepositoy extends JpaRepository<Post,Long> {


    List<Post> findByUserId(Long userId);
}
