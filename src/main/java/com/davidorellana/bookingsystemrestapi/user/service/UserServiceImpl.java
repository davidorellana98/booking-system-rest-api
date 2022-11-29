package com.davidorellana.bookingsystemrestapi.user.service;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryDao userRepositoryDao;

    @Override
    public HashMap<Long, User> getAllUsers() {
        return userRepositoryDao.getAllUsers();
    }

    @Override
    public User findUserById(Long idUser) {
        return userRepositoryDao.findUserById(idUser);
    }

    @Override
    public User createUser(UserDto userDto) {
        return userRepositoryDao.createUser(userDto);
    }

    @Override
    public User updateUserById(Long idUser, UserDto userDto) {
        return userRepositoryDao.updateUserById(idUser, userDto);
    }

    @Override
    public Boolean deleteUserById(Long idUser) {
        return userRepositoryDao.deleteUserById(idUser);
    }
}
