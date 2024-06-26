package com.kk.spring_security_tut.repository;

import com.kk.spring_security_tut.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByUsername(String username);
}
