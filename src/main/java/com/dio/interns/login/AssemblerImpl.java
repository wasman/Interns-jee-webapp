package com.dio.interns.login;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Arrays.asList;

@Service("assembler")
public class AssemblerImpl implements Assembler {

    @Override
    @Transactional(readOnly = true)
    public User buildUserFromUserEntity(UserEntity userEntity) {
        return new User(
                userEntity.getUserName(),
                userEntity.getPassword(),
                true,true,true,true,
                asList(new SimpleGrantedAuthority("supervisor")));  //To change body of created methods use File | Settings | File Templates.
    }
}
