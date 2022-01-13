package com.web.news.User.Converter;

import java.util.HashSet;
import java.util.Set;

import com.web.news.Role.Entity.RoleEntity;
import com.web.news.Security.Utils.SecurityUtils;
import com.web.news.User.Domain.UserDto;
import com.web.news.User.Entity.UserEntity;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    
    public UserEntity toEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        String userPasswordEncrypt = SecurityUtils.encryptPassword(userDto.getPassword());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userPasswordEncrypt);
        return userEntity;
    }

    public UserDto toDto (UserEntity userEntity) {
        UserDto userDto = new UserDto();
        Set<String> roles = new HashSet<>();
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        for(RoleEntity roleEntity : userEntity.getRolesEntity()){
            roles.add(roleEntity.getName());
        }
        userDto.setRoles(roles);
        return userDto;
    }

    public UserEntity toEntity(UserDto userDto, UserEntity oldUserEntity) {
        String userPasswordEncrypt = SecurityUtils.encryptPassword(userDto.getPassword());
        oldUserEntity.setPassword(userPasswordEncrypt);
        return oldUserEntity;
    }
}
