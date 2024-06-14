package com.kk.spring_security_tut.services;

import com.kk.spring_security_tut.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<User>();

    public UserService() {
        users.add(new User("abc","def","ABC@GMAIL.COM","ADMIN"));
        users.add(new User("xyz","uvw","XYZ@GMAIL.COM","USER"));
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public User getUser(String username){
        return this.users.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.users.add(user);
        return user;
    }
}
