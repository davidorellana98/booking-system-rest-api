package com.davidorellana.bookingsystemrestapi.user.service;

import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;
import com.davidorellana.bookingsystemrestapi.user.repository.UserRepositoryDao;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {

    @Mock
    private UserRepositoryDao userRepositoryDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @Order(1)
    public void find_all_users() {

        List<User> userListMockito = new ArrayList<>();
        userListMockito.add(new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345"));
        userListMockito.add(new User( "felipe", "calvache", 28, "123457", "felipe@mail.com", "12345"));

        Mockito.when(userRepositoryDao.findAllUsers()).thenReturn(userListMockito);

        List<User> userListResult = userService.findAllUsers();

        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345"));
        userListExpected.add(new User("felipe", "calvache", 28, "123457", "felipe@mail.com", "12345"));

        Assertions.assertEquals(userListExpected, userListResult);
    }

    @Test
    @Order(2)
    public void find_user_by_id() {

        User userMockito = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");

        Mockito.when(userRepositoryDao.findUserById("1")).thenReturn(userMockito);

        User userResult = userService.findUserById("1");
        User userExpected = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");

        Assertions.assertEquals(userExpected, userResult);
    }

    @Test
    @Order(3)
    public void create_user() {

        UserDto userDtoMockito = new UserDto("luis", "orellana", 25, "123456", "luis@mail.com", "12345");
        User userMockito = new User(userDtoMockito);

        Mockito.when(userRepositoryDao.createUser(userDtoMockito)).thenReturn(userMockito);

        User userResult = userService.createUser(userDtoMockito);
        User userExpected = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");

        Assertions.assertTrue(userExpected.equals(userResult));
    }

    @Test
    @Order(4)
    public void update_user_by_id() {
        UserUpdatedDto userUpdatedDtoMockito = new UserUpdatedDto("luis", "orellana", 25, "luis@mail.com", "12345");
        User userMockito = new User(userUpdatedDtoMockito);

        Mockito.when(userRepositoryDao.updateUserById("1", userUpdatedDtoMockito)).thenReturn(userMockito);

        User userResult = userService.updateUserById("1", userUpdatedDtoMockito);

        Assertions.assertEquals(userMockito, userResult);
    }

    @Test
    @Order(5)
    public void delete_user_by_id() {

        Mockito.when(userRepositoryDao.deleteUserById("1")).thenReturn(true);

        Boolean userResult = userService.deleteUserById("1");

        Assertions.assertEquals(true, userResult);
    }

    @Test
    @Order(8)
    public void find_user_by_name_and_lastName() {

        List<User> userListMockito = new ArrayList<>();
        userListMockito.add(new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345"));
        userListMockito.add(new User( "felipe", "calvache", 28, "123457", "felipe@mail.com", "12345"));

        Mockito.when(userRepositoryDao.findUserByNameAndLastName("luis", "orellana")).thenReturn(userListMockito);

        List<User> userFoundNameAndLastNameResult = userService.findUserByNameAndLastName("luis", "orellana");
        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345"));
        userListExpected.add(new User( "felipe", "calvache", 28, "123457", "felipe@mail.com", "12345"));

        Assertions.assertEquals(userListExpected, userFoundNameAndLastNameResult);
    }

    @Test
    @Order(9)
    public void find_user_by_identityCard() {

        User userIdentityMockito = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");

        Mockito.when(userRepositoryDao.findUserByIdentityCard("123456")).thenReturn(userIdentityMockito);

        User userByIdentityCardResult = userService.findUserByIdentityCard("123456");
        User userIdentityExpected = new User("luis", "orellana", 25, "123456", "luis@mail.com", "12345");
        Assertions.assertEquals(userIdentityExpected, userByIdentityCardResult);
    }
}