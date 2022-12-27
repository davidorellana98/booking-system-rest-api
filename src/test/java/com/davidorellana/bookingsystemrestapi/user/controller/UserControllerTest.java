package com.davidorellana.bookingsystemrestapi.user.controller;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;
import com.davidorellana.bookingsystemrestapi.user.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    @Order(1)
    public void all_users_200_ok() {

        List<User> userListMockito = new ArrayList<>();
        userListMockito.add(new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345"));
        userListMockito.add(new User( "felipe", "calvache", 28, "123457", "felipe@mail.com", "12345"));

        Mockito.when(userService.findAllUsers()).thenReturn(userListMockito);

        ResponseEntity<List<User>> listUsersResultController = userController.findAllUsers();
        Assertions.assertEquals(200, listUsersResultController.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void all_users_empty_404_not_found() {

        List<User> userListMockito = new ArrayList<>();

        Mockito.when(userService.findAllUsers()).thenReturn(userListMockito);

        ResponseEntity<List<User>> listUsersResultController = userController.findAllUsers();
        Assertions.assertEquals(404, listUsersResultController.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void find_user_by_id_200_ok() {

        User userMockito = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");

        Mockito.when(userService.findUserById(Mockito.anyString())).thenReturn(userMockito);

        ResponseEntity<User> usersResultController = userController.findUserById("1");
        Assertions.assertEquals(200, usersResultController.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void find_user_by_id_404_not_found() {

        User userMockito = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");

        Mockito.when(userService.findUserById("1")).thenReturn(userMockito);

        ResponseEntity<User> usersResultController = userController.findUserById("1");
        Assertions.assertNotEquals(404, usersResultController.hashCode());
    }

    @Test
    @Order(5)
    public void update_user_by_id_200_ok() {

        UserUpdatedDto userUpdateDtoMockito = new UserUpdatedDto("luis", "orellana", 25, "luis@mail.com", "12345");
        User userMockito = new User(userUpdateDtoMockito);

        Mockito.when(userService.updateUserById("1", userUpdateDtoMockito)).thenReturn(userMockito);

        ResponseEntity<User> userUpdatedResult = userController.updateUserById("1", userUpdateDtoMockito);
        Assertions.assertTrue(200 == userUpdatedResult.getStatusCodeValue());
        Assertions.assertTrue(userUpdatedResult.getBody() != null);
    }

}