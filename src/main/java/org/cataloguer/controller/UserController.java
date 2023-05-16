package org.cataloguer.controller;

import org.cataloguer.openapi.api.UserApi;
import org.cataloguer.openapi.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class UserController implements UserApi {
    @Override
    public ResponseEntity<User> addUser(User user) {
        return UserApi.super.addUser(user);
    }

    @Override
    public ResponseEntity<String> loginUser(User user) {
        return UserApi.super.loginUser(user);
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return UserApi.super.logoutUser();
    }
}
