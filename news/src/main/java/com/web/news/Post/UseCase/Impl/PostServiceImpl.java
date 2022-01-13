package com.web.news.Post.UseCase.Impl;

import java.util.ArrayList;
import java.util.List;

import com.web.news.Category.Entity.CategoryEntity;
import com.web.news.Category.Repository.CategoryRepository;
import com.web.news.Post.Converter.PostConverter;
import com.web.news.Post.Domain.PostDto;
import com.web.news.Post.Entity.PostEntity;
import com.web.news.Post.Repository.PostRepository;
import com.web.news.Post.UseCase.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostConverter postConverter;
    

    @Override
    public List<PostDto> getAllPost(Pageable pageable) {
        List<PostDto> listPostDto = new ArrayList<>();
        List<PostEntity> listPostEntity = postRepository.findAll(pageable).getContent();
        for (PostEntity postEntity : listPostEntity) {
            listPostDto.add(postConverter.toDto(postEntity));
        }
        return listPostDto;
    }

    @Override
    public PostDto getPost(Long id) {
        PostEntity postEntity = postRepository.getById(id);
        return postConverter.toDto(postEntity);
    }

    @Override
    public PostDto save(PostDto post) {
        PostEntity postEntity = new PostEntity();
        postEntity = postConverter.toEntity(post);
        CategoryEntity category = categoryRepository.findOneByCode(post.getCategoryCode());
        postEntity.setCategory(category);
        postEntity = postRepository.save(postEntity);
        return postConverter.toDto(postEntity);
    }

    @Override
    public PostDto update(PostDto post) {
        PostEntity postEntity = new PostEntity();
        PostEntity oldPostEntity = postRepository.getById(post.getId());
        postEntity = postConverter.toEntity(post, oldPostEntity);
        CategoryEntity category = categoryRepository.findOneByCode(post.getCategoryCode());
        postEntity.setCategory(category);
        postEntity = postRepository.save(postEntity);
        return postConverter.toDto(postEntity);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public int countPost() {
        return (int) postRepository.count();
    }

    
}
