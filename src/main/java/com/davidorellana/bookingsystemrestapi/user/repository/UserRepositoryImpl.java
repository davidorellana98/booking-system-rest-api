package com.davidorellana.bookingsystemrestapi.user.repository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;
import com.davidorellana.bookingsystemrestapi.user.repository.mongorepository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UserRepositoryImpl(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userMongoRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        Optional<User> userByIdFound = userMongoRepository.findById(id);
        if (userByIdFound.isPresent()) {
            return userByIdFound.get();
        }
        return null;
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto);
        return userMongoRepository.save(user);

    }

    @Override
    public User updateUserById(String id, UserUpdatedDto userUpdatedDto) {
        User userFound = findUserById(id);
        if (userFound != null) {
            userFound.updateUserCollection(userUpdatedDto);
            return userMongoRepository.save(userFound);
        }
        return null;
    }

    @Override
    public Boolean deleteUserById(String id) {
        User userFound = findUserById(id);
        if (userMongoRepository.existsById(id)) {
            userMongoRepository.delete(userFound);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllUsers() {
        List<User> usersFound = findAllUsers();
        userMongoRepository.deleteAll(usersFound);
    }

    @Override
    public List<User> findUserByNameAndLastName(String name, String lastName) {
        List<User> userByNameAndLastNameFound = userMongoRepository.findUserByNameAndLastName(name, lastName)
;        if (userByNameAndLastNameFound.isEmpty()) {
            return null;
        }
        return userByNameAndLastNameFound;
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> userByEmailFound = userMongoRepository.findUserByEmail(email);
        if (userByEmailFound.isPresent()) {
            return userByEmailFound.get();
        }
        return null;
    }

    @Override
    public User findUserByIdentityCard(String identityCard) {
        Optional<User> userByEmailFound = userMongoRepository.findUserByIdentityCard(identityCard);
        if (userByEmailFound.isPresent()) {
            return userByEmailFound.get();
        }
        return null;
    }
}
