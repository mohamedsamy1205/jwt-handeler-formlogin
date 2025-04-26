package com.jwt.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conroller {
    @Autowired
    private UserServices uServices;
    @PostMapping("/sign-in")
    public String creatuswr(@RequestBody Model user) {

        uServices.signIn(user);
        return "User is Created !";
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return uServices.login(loginRequest);
    }
}
