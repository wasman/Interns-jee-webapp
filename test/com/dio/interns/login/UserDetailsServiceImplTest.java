package com.dio.interns.login;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: kislo_metal
 * Date: 02.02.13
 * Time: 17:38
 */
public class UserDetailsServiceImplTest {


    @Test
    public void testLoadUserByUsername() throws Exception {
        // initialize variable inputs
        String inputValue = "userName";
        GrantedAuthority authority = new SimpleGrantedAuthority("supervisor");
        User expectedValue = new User("userName","somePassword",true,true,true,true, asList(authority));
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(inputValue);


        // initialize mocks
        UserEntityDao userEntityDao = mock(UserEntityDao.class);
        Assembler assembler = mock(Assembler.class);

        when(userEntityDao.findUserByName(inputValue)).thenReturn(userEntity);
        when(assembler.buildUserFromUserEntity(userEntity)).thenReturn(expectedValue);

        // initialize class to test
        UserDetailsServiceImpl testClass = new UserDetailsServiceImpl(userEntityDao, assembler);

        // invoke method on class to test
        UserDetails returnValue = testClass.loadUserByUsername(inputValue);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameThrowException() throws Exception {
        // initialize variable inputs
        String inputValue = "userName";


        // initialize mocks
        UserEntityDao userEntityDao = mock(UserEntityDao.class);

        when(userEntityDao.findUserByName(inputValue)).thenReturn(null);

        // initialize class to test
        UserDetailsServiceImpl testClass = new UserDetailsServiceImpl(userEntityDao, null);

        // invoke method on class to test
        UserDetails returnValue = testClass.loadUserByUsername(inputValue);

        // assert return value


        // verify mock expectations
    }


}
