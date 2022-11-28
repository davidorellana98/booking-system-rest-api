package com.davidorellana.bookingsystemrestapi.user.controller;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Long, User>> getAllUsers() {
        HashMap<Long, User> listAllUsers = userService.getAllUsers();
        if (listAllUsers.isEmpty()) {
            return new ResponseEntity("There are no users to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listAllUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long idUser) {
        User userById = userService.findUserById(idUser);
        if (userById != null) {
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }
        return new ResponseEntity("That user id does not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        Optional<User> userValidation = Optional.ofNullable(userService.createUser(userDto));
        if (userValidation != null) {
            return new ResponseEntity("Created user!", HttpStatus.CREATED);
        }
        return new ResponseEntity("User not created!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long idUser, @RequestBody UserDto userDto) {
        User isUpdated = userService.updateUserById(idUser, userDto);
        if (isUpdated != null){
            return new ResponseEntity("Updated user!", HttpStatus.OK);
        }else{
            return new ResponseEntity("User not updated by id not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long idUser) {
        Boolean isDeletedUserById = userService.deleteUserById(idUser);
        if (isDeletedUserById) {
            return new ResponseEntity("Deleted user!", HttpStatus.OK);
        }
        return new ResponseEntity("The user does not exist to be deleted!", HttpStatus.NOT_FOUND);
    }
}