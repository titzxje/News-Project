package com.web.news.Post.ApiController;

import java.util.ArrayList;
import java.util.List;

import com.web.news.Post.Domain.PostDto;

public class PostOutput {
    private int page;
    private int totalPages;
    private List<PostDto> posts = new ArrayList<>();
    
    public PostOutput() {
    }

    public PostOutput(int page, int totalPages, List<PostDto> posts) {
        this.page = page;
        this.totalPages = totalPages;
        this.posts = posts;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<PostDto> getPosts() {
        return posts;
    }
    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
}
