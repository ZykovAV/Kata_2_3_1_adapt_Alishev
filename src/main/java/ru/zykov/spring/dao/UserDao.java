package ru.zykov.spring.dao;

import ru.zykov.spring.models.User;

import java.util.List;

public interface UserDao {

    public List<User> index();

    public List<User> getAllUsers();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);

}
