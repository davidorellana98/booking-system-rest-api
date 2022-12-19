package com.davidorellana.bookingsystemrestapi.user.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String lastName;
    private Integer age;
    private String identityCard;
    private String email;
    private String password;

    public UserDto() { }

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

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", identityCard='" + identityCard + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name) && Objects.equals(lastName, userDto.lastName) && Objects.equals(age, userDto.age) && Objects.equals(identityCard, userDto.identityCard) && Objects.equals(email, userDto.email) && Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age, identityCard, email, password);
    }
}
