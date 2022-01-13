package com.web.news.User.Repository;

import com.web.news.User.Entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
     UserEntity findByUsername(String username);
}
