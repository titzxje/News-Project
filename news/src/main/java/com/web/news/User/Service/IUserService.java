package com.web.news.User.Service;

import com.web.news.User.Domain.UserDto;

public interface IUserService {

    Boolean validateUser(String username);
    UserDto getUserDetail(String username);
    UserDto changePassword(UserDto userDto);
    UserDto register(UserDto userDto);
}
