package com.bbz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private CustomUserDetailsImplService customUserDetailsImplService;
//
//
//    @Autowired
//    private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .passwordEncoder(passwordEncoder())
////                .withUser("admin")
////                .password(passwordEncoder().encode("123"))
////                .roles("USER");
////        auth.userDetailsService();
//
//
//        auth.userDetailsService(customUserDetailsImplService)
//                .passwordEncoder(passwordEncoder());
//
////        auth.jdbcAuthentication()
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
//        return new MessageDigestPasswordEncoder("MD5");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
