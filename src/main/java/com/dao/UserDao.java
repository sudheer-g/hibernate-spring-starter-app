package com.dao;

import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("com.dao.UserDao")
public class UserDao extends GenericDaoImpl<User, Integer>{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public HibernateTemplate getTemplate() {
        return this.hibernateTemplate;
    }
}