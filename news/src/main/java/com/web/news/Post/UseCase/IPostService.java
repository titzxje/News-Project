package com.web.news.Post.UseCase;

import java.util.List;

import com.web.news.Post.Domain.PostDto;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IPostService {
    public List<PostDto> getAllPost(Pageable pageable);
    public PostDto getPost(Long id);
    public PostDto save(PostDto post);
    public PostDto update(PostDto post);
    public void delete(Long id);
    public int countPost();
}
