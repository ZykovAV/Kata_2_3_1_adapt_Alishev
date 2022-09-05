package ru.zykov.spring.services;

import ru.zykov.spring.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
}
