package com.org.isdb62.controller;

import com.org.isdb62.annotation.CurrentUser;
import com.org.isdb62.model.CustomUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public CustomUser user(@CurrentUser CustomUser currentUser) {
        return currentUser;
    }
}
