package com.web.news.User.Service.Impl;


import java.util.HashSet;
import java.util.Set;

import com.web.news.Role.Entity.RoleEntity;
import com.web.news.Role.Repository.RoleRepository;
import com.web.news.User.Converter.UserConverter;
import com.web.news.User.Domain.UserDto;
import com.web.news.User.Domain.UserPrincipal;
import com.web.news.User.Entity.UserEntity;
import com.web.news.User.Repository.UserRepository;
import com.web.news.User.Service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new UserPrincipal(userEntity);
    }

    @Override
    public Boolean validateUser(String username){
        if (userRepository.findByUsername(username) != null) {
            return false;
        }
        return true;
    }

    @Override
    public UserDto getUserDetail(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        return userConverter.toDto(userEntity);
    }

    @Override
    public UserDto register(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        Set<RoleEntity> listRolesEntity = new HashSet<RoleEntity>();
        for(String role : userDto.getRoles()) {
            RoleEntity roleEntity = roleRepository.findByName(role);
            listRolesEntity.add(roleEntity);
        }
        userEntity = userConverter.toEntity(userDto);
        userEntity.setRolesEntity(listRolesEntity);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDto(userEntity);
    }
    
    public UserDto changePassword(UserDto userDto){
        UserEntity oldUserEntity = userRepository.findByUsername(userDto.getUsername());
        if(oldUserEntity != null) {
            UserEntity userEntity = userConverter.toEntity(userDto, oldUserEntity);
            userEntity = userRepository.save(userEntity);
            return userConverter.toDto(userEntity);
        }
        return null;
    }
}
