package com.davidorellana.bookingsystemrestapi.user.service;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;
import com.davidorellana.bookingsystemrestapi.user.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryDao userRepositoryDao;

    @Autowired
    public UserServiceImpl(UserRepositoryDao userRepositoryDao) {
        this.userRepositoryDao = userRepositoryDao;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepositoryDao.findAllUsers();
    }

    @Override
    public User findUserById(String id) {
        return userRepositoryDao.findUserById(id);
    }

    @Override
    public User createUser(UserDto userDto) {
        return userRepositoryDao.createUser(userDto);
    }

    @Override
    public User updateUserById(String id, UserUpdatedDto userUpdatedDto) {
        return userRepositoryDao.updateUserById(id, userUpdatedDto);
    }

    @Override
    public Boolean deleteUserById(String id) {
        return userRepositoryDao.deleteUserById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepositoryDao.deleteAllUsers();
    }

    @Override
    public List<User> findUserByNameAndLastName(String name, String lastName) {
        return userRepositoryDao.findUserByNameAndLastName(name, lastName);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepositoryDao.findUserByEmail(email);
    }
}
