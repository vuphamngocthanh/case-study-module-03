package com.cg.module03casestudy.model.service;

import com.cg.module03casestudy.dao.UserDao;
import com.cg.module03casestudy.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    private UserDao userDao = null;

    public AuthService () {
        userDao = new UserDao();
    }

    public UserDto login(String email, String password) {
        UserDto userDto = userDao.get(email);
        boolean isCorrectPassword;
        if (userDto == null) {
            return null;
        } else {
            isCorrectPassword = BCrypt.checkpw(password, userDto.getPassword());
            if (isCorrectPassword) {
                return userDto;
            } else {
                return null;
            }
        }
    }
}
