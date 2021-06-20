package com.ivuglec2.springprimefaces.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            // require all requests to be authenticated except for the resources and allowed pages
            .antMatchers("/javax.faces.resource/**", "/", "/index.jsf", "/view/**").permitAll()
            // require authentication for every requests not matching allowed path
            .anyRequest().authenticated()
            .and()
        // login
        .formLogin()
            .loginPage("/view/login.jsf")
            .permitAll()
            .failureUrl("/view/login.jsf?error=true")
            .defaultSuccessUrl("/secured/securedPage.jsf")
            .and()
        // logout
        .logout().permitAll()
            .deleteCookies("JSESSIONID")
            .and()
        // not needed as JSF 2.2 is implicitly protected against CSRF
        .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                    .and()
                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                    .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
