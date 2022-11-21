package com.davidorellana.bookingsystemrestapi.user.service;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserServiceI {

    private final HashMap<Long, User> userServiceHashMap = new HashMap<>();

    @Override
    public HashMap<Long, User> allUsers() {
        return userServiceHashMap;
    }

    @Override
    public User findUserById(Long idUser) {
        return userServiceHashMap.get(idUser);
    }

    @Override
    public User createUser(User user) {
        Long keyUser = user.getId();
        return userServiceHashMap.put(keyUser, user);
    }

    @Override
    public User updateUserById(Long idUser, User user) {
        Long keyUser = user.setId(idUser);
        return userServiceHashMap.replace(keyUser, user);
    }

    @Override
    public User deleteUserById(Long idUser) {
        return userServiceHashMap.remove(idUser);
    }
}
