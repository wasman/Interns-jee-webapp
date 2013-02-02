package com.dio.interns.login;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserEntityDaoImplTest {

    @Test
    public void testFindUserByName() throws Exception {
        // initialize variable inputs
        UserEntity expectedValue = new UserEntity();
        String inputValue = "some user";

        // initialize mocks
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        Query query = mock(Query.class);
        when(session.createQuery("SELECT u from UserEntity u where u.userName =  '" + inputValue + "'")).thenReturn(query);
        when(query.uniqueResult()).thenReturn(expectedValue);

        // initialize class to test
        UserEntityDaoImpl testClass = new UserEntityDaoImpl(sessionFactory);

        // invoke method on class to test
        UserEntity returnValue = testClass.findUserByName(inputValue);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
    }
}
