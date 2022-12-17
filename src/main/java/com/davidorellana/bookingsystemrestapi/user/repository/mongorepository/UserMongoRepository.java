package com.davidorellana.bookingsystemrestapi.user.repository.mongorepository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> { }
