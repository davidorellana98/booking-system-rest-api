package com.davidorellana.bookingsystemrestapi.user.controller;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceI userService;

    @Autowired
    public UserController(UserServiceI userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Long, User>> allUsers() {
        HashMap<Long, User> userList = userService.allUsers();
        if (userList.isEmpty()) {
            return new ResponseEntity("There are no users to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long idUser) {
        User userById = userService.findUserById(idUser);
        if (userById != null) {
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }
        return new ResponseEntity("That user id does not exist!", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        Optional<User> newUser = Optional.ofNullable(userService.createUser(user));
        if (newUser != null) {
            return new ResponseEntity("Created user!", HttpStatus.CREATED);
        }
        return new ResponseEntity("User not created!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long idUser, @RequestBody UserDto userDto) {
        User updateUser = new User(userDto);
        User newUser = userService.updateUserById(updateUser.setId(idUser), updateUser);
        if (newUser != null) {
            return ResponseEntity.ok(newUser);
        }
        return new ResponseEntity("User not updated by id not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long idUser) {
        User deleteUser = userService.deleteUserById(idUser);
        if (deleteUser != null) {
            return new ResponseEntity("User Deleted!", HttpStatus.OK);
        }
        return new ResponseEntity("The user does not exist to be deleted!", HttpStatus.NOT_FOUND);
    }
}
