package com.web.news.Security.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtils {

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder encryptPassword = new BCryptPasswordEncoder();
        return encryptPassword.encode(password);
    }
}
