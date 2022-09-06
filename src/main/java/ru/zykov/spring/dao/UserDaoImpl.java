package ru.zykov.spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.zykov.spring.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {

        TypedQuery<User> oneUserQuery = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        oneUserQuery.setParameter("id", id);
        return oneUserQuery.getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(int id){
        entityManager.remove(getUser(id));
    }
}
