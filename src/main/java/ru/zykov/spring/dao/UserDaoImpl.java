package ru.zykov.spring.dao;

import org.springframework.stereotype.Component;
import ru.zykov.spring.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private static int UserCount;
    //    UserDao userDao = new UserDaoImpl();
    List<User> userList;

    {
        this.userList = new ArrayList<>();
        userList.add(new User(++UserCount, "Steve", "Yzerman", (byte) 47));
        userList.add(new User(++UserCount, "Igor", "Larionov", (byte) 51));
        userList.add(new User(++UserCount, "Mario", "Lemieux", (byte) 53));
        userList.add(new User(++UserCount, "Pat", "Lafontaine", (byte) 50));
    }

    public UserDaoImpl() {
    }

    @Override
    public List<User> index() {
        return userList;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User show(int id) {
//        return personList.get(id);
        return userList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++UserCount);
        userList.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdate = show(id);
        userToBeUpdate.setName(updatedUser.getName());
    }
}
