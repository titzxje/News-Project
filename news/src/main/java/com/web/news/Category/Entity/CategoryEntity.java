package com.web.news.Category.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.web.news.Post.Entity.AbstractEntity;
import com.web.news.Post.Entity.PostEntity;

@Entity
@Table(name = "category")
public class CategoryEntity extends AbstractEntity {
    
    @Column
    private String code;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<PostEntity> posts = new ArrayList<>();

    public CategoryEntity(String code, String name, List<PostEntity> posts) {
        this.code = code;
        this.name = name;
        this.posts = posts;
    }

    public CategoryEntity() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
    

}
