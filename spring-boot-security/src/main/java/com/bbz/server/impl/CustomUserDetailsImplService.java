package com.bbz.server.impl;

import com.bbz.server.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsImplService implements CustomUserDetailsService, UserDetailsService {

    //    private final List<CustomUser> users = new ArrayList<>();
//
    @Autowired
    private PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    void init() {
//
//        users.add(new CustomUser("admin", passwordEncoder.encode("123")));
//        users.stream().peek(user -> System.out.println(user.getPassword())).count();
//
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        CustomUser customUser = userData(username);
//        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
//        grantedAuthorities.add(grantedAuthority);
//        return new User(customUser.getUsername(), customUser.getPassword(), grantedAuthorities);

        return User.withUsername("admin").password("123").authorities("p1").build();
    }


//    public CustomUser userData(String username) {
//        return users.stream().filter(f -> Strings.equals(username, f.getUsername())).findAny().orElse(null);
//    }
//
//    @Override
//    public CustomUser findCustomUserByUserNameAndPassWord(String userName, String passWord) {
////        CustomUser customUser = userData(userName);
////        UserDetails userDetails = loadUserByUsername(userName);
//
//        return null;
//    }
}
