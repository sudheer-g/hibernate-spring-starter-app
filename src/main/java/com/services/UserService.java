package com.services;

import com.models.User;

public interface UserService {

    User create(User user);
    User getById(int id);
    User editUser(int id);
    boolean delete(int id);
}