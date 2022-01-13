package com.web.news.Post.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDto<T> {
    private Long id;
    private Date updatedAt;
    private Date createdAt;
    private String updatedBy;
    private String createdBy;
    private List<T> list = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }

    
}
