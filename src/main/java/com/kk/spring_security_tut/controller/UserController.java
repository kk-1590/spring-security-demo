package com.kk.spring_security_tut.controller;

import com.kk.spring_security_tut.models.User;
import com.kk.spring_security_tut.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){
        return this.userService.addUser(user);
    }

}
