package com.rs.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

   /* @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        UserDetails user = User.builder()
                .username("phongpro1")
                .password("$2a$10$CdpQzwoxU0NzQ7axoG3LnuXNB6kO6oSvElBw8nBQpai8gLtGU4bWO")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin1")
                .password("$2a$10$CdpQzwoxU0NzQ7axoG3LnuXNB6kO6oSvElBw8nBQpai8gLtGU4bWO")
                .roles("USER", "ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return new InMemoryUserDetailsManager(user, admin);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/v1/register").permitAll()
                .antMatchers("/v1/greeting").authenticated()
                .and().formLogin()
                .and().httpBasic();
        return httpSecurity.build();
    }
}
