package com.dio.interns.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: kislo_metal
 * Date: 02.02.13
 * Time: 17:38
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityDao userEntityDao;
    private final Assembler assembler;

    @Autowired
    public UserDetailsServiceImpl(UserEntityDao userEntityDao, Assembler assembler) {
        this.userEntityDao = userEntityDao;
        this.assembler = assembler;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userByName = userEntityDao.findUserByName(username);

        if (userByName == null){
            throw new UsernameNotFoundException("user not found");
        }
        return assembler.buildUserFromUserEntity(userByName);
    }
}
