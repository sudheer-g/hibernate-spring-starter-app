package services;

import dao.UserDao;
import models.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("hrdb.UserService")
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Override
    @Transactional
    public User create(User user) {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
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
