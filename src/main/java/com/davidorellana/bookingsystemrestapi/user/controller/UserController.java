package com.davidorellana.bookingsystemrestapi.user.controller;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;
import com.davidorellana.bookingsystemrestapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.findAllUsers();
        if (allUsers.isEmpty()) {
            return new ResponseEntity("The user collection is empty.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) {
        User userByIdFound = userService.findUserById(id);
        if (userByIdFound != null) {
            return new ResponseEntity<>(userByIdFound, HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " does not exist in the users collection.", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User userCreated = userService.createUser(userDto);
        if (userCreated != null) {
            return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity("The creation of the user could not be carried out, due to a duplicate email or identity card in the list.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable String id, @RequestBody UserUpdatedDto userUpdatedDto) {
        User userUpdated = userService.updateUserById(id, userUpdatedDto);
        if (userUpdated != null) {
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        }
        return new ResponseEntity("User update failed, due to incorrect id or duplicate email.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable String id) {
        if (userService.deleteUserById(id)) {
            return new ResponseEntity("Deleted user.", HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " is not found in the collection of users to delete.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity deleteAllUsers() {
        List<User> allUsers = userService.findAllUsers();
        userService.deleteAllUsers();
        if (allUsers.isEmpty()) {
            return new ResponseEntity("There is no collection of users to delete.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Correct deletion of the entire user collection.", HttpStatus.OK);
    }

    @GetMapping("/nameAndLastName/{name}/{lastName}")
    public ResponseEntity<List<User>> findUserByNameAndLastName(@PathVariable String name, @PathVariable String lastName) {
        List<User> userByNameAndLastNameFound = userService.findUserByNameAndLastName(name, lastName);
        if (userByNameAndLastNameFound != null) {
            return new ResponseEntity<>(userByNameAndLastNameFound, HttpStatus.OK);
        }
        return new ResponseEntity("The user " + name + " " + lastName +", do not exist in the users collection.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/identityCard/{identityCard}")
    public ResponseEntity<User> findUserByIdentityCard(@PathVariable String identityCard) {
        User userByIdentityCardFound = userService.findUserByIdentityCard(identityCard);
        if (userByIdentityCardFound != null) {
            return new ResponseEntity<>(userByIdentityCardFound, HttpStatus.OK);
        }
        return new ResponseEntity("The identity Card " + identityCard + " is not related to any user.", HttpStatus.NOT_FOUND);
    }
}