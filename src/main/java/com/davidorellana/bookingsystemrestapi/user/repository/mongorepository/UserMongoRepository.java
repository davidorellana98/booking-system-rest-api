package com.davidorellana.bookingsystemrestapi.user.repository.mongorepository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {

    @Query(value = "{'name' : ?0, 'lastName' : ?1}", exists = true)
    List<User> findUserByNameAndLastName(String name, String lastName);

    @Query(value = "{'email' : ?0}")
    Optional<User> findUserByEmail(String email);

    @Query(value = "{'identityCard' : ?0}")
    Optional<User> findUserByIdentityCard(String identityCard);
}
