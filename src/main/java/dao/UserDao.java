package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    public void getById(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.get(User.class, userId);
    }

    public void remove(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(user);
    }

}