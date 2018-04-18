package com.dao;

import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("com.dao.UserDao")
@Transactional
public class UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public User save(User user) {
        hibernateTemplate.saveOrUpdate(user);
        hibernateTemplate.flush();
        return user;
    }

    public User getById(int userId) {
        return hibernateTemplate.get(User.class, userId);
    }

    public User remove(int id) {
        User deleted = getById(id);
        hibernateTemplate.delete(deleted);
        hibernateTemplate.flush();
        return deleted;
    }

}