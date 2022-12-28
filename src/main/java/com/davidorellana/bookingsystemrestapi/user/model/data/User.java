package com.davidorellana.bookingsystemrestapi.user.model.data;

import com.davidorellana.bookingsystemrestapi.user.model.dto.UserDto;
import com.davidorellana.bookingsystemrestapi.user.model.dto.UserUpdatedDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "user_collection")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    @Indexed(unique = true)
    private String identityCard;
    @Indexed(unique = true)
    private String email;
    private String password;

    public User() { }

    public User(String name, String lastName, Integer age, String identityCard, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.identityCard = identityCard;
        this.email = email;
        this.password = password;
    }

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.age = userDto.getAge();
        this.identityCard = userDto.getIdentityCard();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }

    public User(UserUpdatedDto userUpdatedDto) {
        this.updateUserCollection(userUpdatedDto);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void updateUserCollection(UserUpdatedDto userUpdatedDto) {
        this.name = userUpdatedDto.getName();
        this.lastName = userUpdatedDto.getLastName();
        this.age = userUpdatedDto.getAge();
        this.email = userUpdatedDto.getEmail();
        this.password = userUpdatedDto.getPassword();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(age, user.age) && Objects.equals(identityCard, user.identityCard) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age, identityCard, email, password);
    }
}