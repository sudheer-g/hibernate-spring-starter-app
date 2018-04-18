package com.services;

import com.dao.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("com.services.UserService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("com.dao.UserDao")
    private UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public User delete(int id) {
        return userDao.remove(id);
    }
}
