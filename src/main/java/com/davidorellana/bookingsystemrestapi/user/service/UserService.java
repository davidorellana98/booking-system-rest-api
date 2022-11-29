package com.davidorellana.bookingsystemrestapi.user.service;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;

import java.util.HashMap;

public interface UserService {

    HashMap<Long, User> getAllUsers();
    User findUserById(Long idUser);
    User createUser(UserDto userDto);
    User updateUserById(Long idUser, UserDto userDto);
    Boolean deleteUserById(Long idUser);
}
