package com.davidorellana.bookingsystemrestapi.user.repository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;

import java.util.List;

public interface UserRepositoryDao {

    List<User> findAllUsers();
    User findUserById(String id);
    User createUser(UserDto userDto);
    User updateUserById(String id, UserUpdatedDto userUpdatedDto);
    Boolean deleteUserById(String id);
    void deleteAllUsers();
    List<User> findUserByNameAndLastName(String name, String lastName);
    User findUserByEmail(String email);
    User findUserByIdentityCard(String identityCard);
}
