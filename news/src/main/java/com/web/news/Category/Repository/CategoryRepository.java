package com.web.news.Category.Repository;

import com.web.news.Category.Entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    CategoryEntity findOneByCode(String code);
}
