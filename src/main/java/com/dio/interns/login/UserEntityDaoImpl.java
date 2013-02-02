package com.dio.interns.login;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityDaoImpl implements UserEntityDao {


    private final SessionFactory sessionFactory;

    @Autowired
    public UserEntityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity findUserByName(String username) {
        return (UserEntity) sessionFactory.getCurrentSession().createQuery("SELECT u from UserEntity u where u.userName =  '" + username + "'").uniqueResult();
    }
}
