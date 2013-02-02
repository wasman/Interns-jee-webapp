package com.dio.interns.login;

import org.springframework.security.core.userdetails.User;

/**
 * User: kislo_metal
 * Date: 02.02.13
 * Time: 17:48
 */
public interface Assembler {
    User buildUserFromUserEntity(UserEntity userEntity);
}
