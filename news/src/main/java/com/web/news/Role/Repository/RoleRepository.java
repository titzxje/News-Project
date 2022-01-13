package com.web.news.Role.Repository;


import com.web.news.Role.Entity.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

     @Query(value= "SELECT * FROM role r WHERE r.name = :name", nativeQuery = true)
     RoleEntity findByName(@Param("name") String name);
}
