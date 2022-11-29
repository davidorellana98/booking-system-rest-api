package com.davidorellana.bookingsystemrestapi.user.repository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;

import java.util.HashMap;

public interface UserRepositoryDao {

    HashMap<Long, User> getAllUsers();
    User findUserById(Long idUser);
    User createUser(UserDto userDto);
    User updateUserById(Long idUser, UserDto userDto);
    Boolean deleteUserById(Long idUser);
}
