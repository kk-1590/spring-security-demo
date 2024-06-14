package com.kk.spring_security_tut;

import com.kk.spring_security_tut.models.User;
import com.kk.spring_security_tut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityTutApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTutApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setUsername("abc");
		user.setPassword(bCryptPasswordEncoder.encode("def"));
		user.setRole("ADMIN");

		userRepository.save(user);

		User user1 = new User();
		user1.setEmail("xyz@gmail.com");
		user1.setUsername("xyz");
		user1.setPassword(bCryptPasswordEncoder.encode("tuv"));
		user1.setRole("USER");

		userRepository.save(user1);
	}
}
