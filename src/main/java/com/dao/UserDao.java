package com.dao;

import com.hibernateConfig.HibernateConfig;
import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository("com.dao.UserDao")
@Transactional
public class UserDao {

    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public User save(User user) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(user);
        transaction.commit();
        currentSession.refresh(user);
        return user;
    }

    public User getById(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, userId);
    }

    public void remove(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(user);
    }

}