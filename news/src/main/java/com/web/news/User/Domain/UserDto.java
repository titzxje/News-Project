package com.web.news.User.Domain;

import java.util.HashSet;
import java.util.Set;

import com.web.news.Post.Domain.AbstractDto;

public class UserDto extends AbstractDto<UserDto>{
    
    private String username;
    private String password;
    private Set<String> roles = new HashSet<>();

    public UserDto(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UserDto() {
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
}
