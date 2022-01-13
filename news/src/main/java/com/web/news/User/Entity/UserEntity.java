package com.web.news.User.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.web.news.Post.Entity.AbstractEntity;
import com.web.news.Role.Entity.RoleEntity;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity{
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns =  @JoinColumn(name="user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> rolesEntity = new HashSet<>();

    public UserEntity(String username, String password, Set<RoleEntity> rolesEntity) {
        this.username = username;
        this.password = password;
        this.rolesEntity = rolesEntity;
    }

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRolesEntity() {
        return rolesEntity;
    }

    public void setRolesEntity(Set<RoleEntity> rolesEntity) {
        this.rolesEntity = rolesEntity;
    }


}
