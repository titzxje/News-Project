package com.web.news.Post.Converter;

import com.web.news.Category.Entity.CategoryEntity;
import com.web.news.Category.Repository.CategoryRepository;
import com.web.news.Post.Domain.PostDto;
import com.web.news.Post.Entity.PostEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public PostEntity toEntity (PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDto.getTitle());
        postEntity.setDescription(postDto.getDescription());
        postEntity.setContent(postDto.getContent());
        postEntity.setThumbnail(postDto.getThumbnail());
        return postEntity;   
    }

    public PostDto toDto(PostEntity postEntity) {
        CategoryEntity category = categoryRepository.getById(postEntity.getCategory().getId());
        PostDto postDto = new PostDto();
        if(postEntity.getId() != null){
            postDto.setId(postEntity.getId());
        }
        postDto.setTitle(postEntity.getTitle());
        postDto.setDescription(postEntity.getDescription());
        postDto.setContent(postEntity.getContent());
        postDto.setThumbnail(postEntity.getThumbnail());
        postDto.setCategoryCode(category.getCode());
        postDto.setCreatedAt(postEntity.getCreatedAt());
        postDto.setUpdatedAt(postEntity.getUpdatedAt());
        postDto.setCreatedBy(postEntity.getCreatedBy());
        postDto.setUpdatedBy(postEntity.getUpdatedBy());
        return postDto;
    }

    public PostEntity toEntity(PostDto postDto, PostEntity postEntity) {
        postEntity.setTitle(postDto.getTitle());
        postEntity.setDescription(postDto.getDescription());
        postEntity.setContent(postDto.getContent());
        postEntity.setThumbnail(postDto.getThumbnail());
        return postEntity;
    }
}