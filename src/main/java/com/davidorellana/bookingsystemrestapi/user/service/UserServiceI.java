package com.davidorellana.bookingsystemrestapi.user.service;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;

import java.util.HashMap;

public interface UserServiceI {

    HashMap<Long, User> allUsers();
    User findUserById(Long idUser);
    User createUser(User user);
    User updateUserById(Long idUser, User user);
    User deleteUserById(Long idUser);
}
