package com.web.news.Post.Repository;

import com.web.news.Post.Entity.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    
}
