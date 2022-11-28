package com.davidorellana.bookingsystemrestapi.user.repository;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> { }
