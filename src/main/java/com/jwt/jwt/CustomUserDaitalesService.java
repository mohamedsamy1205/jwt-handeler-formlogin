package com.jwt.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDaitalesService implements UserDetailsService {
    @Autowired
    private Repository userRepositry;


    private final static String ROLE_PREFIX = "ROLE_";

    // The explicit constructor is removed as @RequiredArgsConstructor generates it automatically.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("UserName : {}", username);
        Model user = userRepositry.findByUsername(username);
//        log.info("User : {}", user.get());
        String password = user.getPassword();
//        log.info("Password{}", password);
        String role = user.getRole();
//        log.info("Role : {}", role);
        role= ROLE_PREFIX+role;
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));

        return new CustomUserDetails(username, password, roles);
    }
}
