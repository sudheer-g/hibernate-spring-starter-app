package com.services;

import com.dao.UserDao;
import com.models.User;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("com.services.UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("com.dao.UserDao")
    private UserDao userDao;

    @Override
    @Transactional
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User editUser(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}