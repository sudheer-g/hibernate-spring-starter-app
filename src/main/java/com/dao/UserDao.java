package com.dao;

import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("com.dao.UserDao")
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
        currentSession.refresh(user);
        return user;
    }

    public User getById(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, userId);
    }

    public User remove(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User deleted = getById(id);
        currentSession.remove(deleted);
        currentSession.flush();
        return deleted;
    }

};