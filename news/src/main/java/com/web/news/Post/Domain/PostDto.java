package com.web.news.Post.Domain;

public class PostDto extends AbstractDto<PostDto> {
    
    private String title;
    private String description;
    private String content;
    private String thumbnail;
    private String categoryCode;

    public PostDto(String title, String description, String content, String thumbnail, String categoryCode) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.categoryCode = categoryCode;
    }

    public PostDto() {
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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    

    
}
