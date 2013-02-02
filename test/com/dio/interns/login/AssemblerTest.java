package com.dio.interns.login;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

/**
 * UserEntity: kislo_metal
 * Date: 02.02.13
 * Time: 17:17
 */
public class AssemblerTest {

    @Test
    public void testBuildUserFromUserEntity() throws Exception {
        // initialize variable inputs
        UserEntity inputValue = new UserEntity();
        inputValue.setUserName("userName");
        inputValue.setPassword("somePassword");
        GrantedAuthority authority = new SimpleGrantedAuthority("supervisor");


        User expectedValue = new User("userName","somePassword",true,true,true,true, asList(authority));

        // initialize mocks

        // initialize class to test
        AssemblerImpl testClass = new AssemblerImpl();

        // invoke method on class to test
        User returnValue = testClass.buildUserFromUserEntity(inputValue);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
    }

}
