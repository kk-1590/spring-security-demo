package com.kk.spring_security_tut.services;

import com.kk.spring_security_tut.models.User;
import com.kk.spring_security_tut.models.UserDetailsCustom;
import com.kk.spring_security_tut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(user + "this is user" + username);
        if(user == null){
            throw new UsernameNotFoundException("No User");
        }
        return new UserDetailsCustom(user);
    }
}
