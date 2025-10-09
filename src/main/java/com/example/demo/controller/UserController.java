package com.example.demo.controller;

import com.example.demo.Dtos.LoginRequest;
import com.example.demo.config.ResponseApi;
import com.example.demo.handler.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<ResponseApi> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
            System.out.println(userDetails);
            return ResponseEntity.ok(new ResponseApi(ResponseStatus.SUCCESS, userDetails));

        } catch (UsernameNotFoundException e) {
             throw new ResourceNotFoundException();
        }
    }
}
