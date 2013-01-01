package com.dio.interns.dao;

import com.dio.interns.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static junit.framework.Assert.assertEquals;

public class UserSetupTest {

    @Test
    public void testSaveAndGet() throws Exception {

        // initialize variable inputs

        // initialize mocks
        User inputValue = new User();

        inputValue.setName("mike");
        inputValue.setPassword("GENM");


        // initialize class to test
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        // invoke method on class to test
        Serializable id = session.save(inputValue);
        session.getTransaction().commit();

        // assert return value

        Query query = session.createQuery("from User where id = " + id);
        assertEquals(1, query.list().size());
        for (Object userObject : query.list()) {
            User returnValue = (User) userObject;
            assertEquals(inputValue, returnValue);
        }

        // verify mock expectations


    }
}
