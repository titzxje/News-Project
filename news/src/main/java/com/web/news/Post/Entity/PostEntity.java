package com.web.news.Post.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.news.Category.Entity.CategoryEntity;


@Entity
@Table(name = "post")
public class PostEntity extends AbstractEntity {
    
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public PostEntity(String title, String description, String content, String thumbnail, CategoryEntity category) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public PostEntity() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
