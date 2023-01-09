package com.davidorellana.bookingsystemrestapi.user.repository.mongorepository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {

    List<User> findUserByNameAndLastName(String name, String lastName);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByIdentityCard(String identityCard);
}
