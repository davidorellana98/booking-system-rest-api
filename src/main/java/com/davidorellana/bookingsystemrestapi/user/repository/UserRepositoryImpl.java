package com.davidorellana.bookingsystemrestapi.user.repository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public HashMap<Long, User> getAllUsers() {
        HashMap<Long, User> usersFounded = new HashMap<>();
        userCrudRepository.findAll().forEach(user -> {
            usersFounded.put(user.getId(), user);
        });
        return usersFounded;
    }

    @Override
    public User findUserById(Long idUser) {
        Optional<User> userFindById = userCrudRepository.findById(idUser);
        if (userFindById.isPresent()) {
            return userFindById.get();
        }
        return null;
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto);
        return userCrudRepository.save(user);
    }

    @Override
    public User updateUserById(Long idUser, UserDto userDto) {
        User userFound = findUserById(idUser);
        if (userFound != null) {
            userFound.setName(userDto.getName());
            userFound.setLastName(userDto.getLastName());
            userFound.setAge(userDto.getAge());
            userFound.setIdentityCard(userDto.getIdentityCard());
            userFound.setEmail(userFound.getEmail());
            return userCrudRepository.save(userFound);
        }
        return userFound;
    }

    @Override
    public Boolean deleteUserById(Long idUser) {
        if (userCrudRepository.existsById(idUser)) {
            userCrudRepository.deleteById(idUser);
            return true;
        }
        return false;
    }
}
