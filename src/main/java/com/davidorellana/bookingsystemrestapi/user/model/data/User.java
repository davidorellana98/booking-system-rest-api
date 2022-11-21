package com.davidorellana.bookingsystemrestapi.user.model.data;

import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;

import java.util.concurrent.atomic.AtomicLong;

public class User {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    static final AtomicLong idIncrement = new AtomicLong(1);

    public User() {
    }

    public User(UserDto userDto) {
        this.id = idIncrement.getAndIncrement();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.age = userDto.getAge();
        this.email = userDto.getEmail();
    }

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
