package com.kk.spring_security_tut.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated())
                //Basic Authentication
//                .httpBasic(Customizer.withDefaults());
                //Form based authentication
                .formLogin(formLogin -> formLogin.loginPage("/signin")
                        .loginProcessingUrl("/doLogin")
                        .defaultSuccessUrl("/signin_success")
                        .permitAll()).
                logout(logout -> logout.logoutUrl("/signout").logoutSuccessUrl("/signin").invalidateHttpSession(true));
        return http.build();
    };

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("kartik")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("amit")
//                .password(passwordEncoder().encode("abc"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}
