package ru.zykov.spring.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "my_db.table")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min=2, max=30, message = "name should be between 2 and 30 characters")

    @Column(name="name")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min=2, max=30, message = "Surname should be between 2 and 30 characters")

    @Column(name="surname")
    private String surname;

    @Min(value = 0, message = "Age should be greater than 0")

    @Column(name="age")
    private byte age;

    public User() {
    }

    public User(long id, String name, String surname, byte age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(String name, String surname, byte age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

}