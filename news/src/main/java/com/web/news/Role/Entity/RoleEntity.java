package com.web.news.Role.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.web.news.User.Entity.UserEntity;

@Entity
@Table(name="role")
public class RoleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @ManyToMany(mappedBy = "rolesEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserEntity> usersEntity = new ArrayList<>();

    public RoleEntity(Long id, String name, List<UserEntity> usersEntity) {
        this.id = id;
        this.name = name;
        this.usersEntity = usersEntity;
    }


    public RoleEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(List<UserEntity> usersEntity) {
        this.usersEntity = usersEntity;
    }

    
}