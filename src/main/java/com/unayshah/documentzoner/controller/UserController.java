package com.unayshah.documentzoner.controller;

import com.unayshah.documentzoner.dao.User;
import com.unayshah.documentzoner.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {
        return new ResponseEntity<>(userService.saveUser(username, password), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {
        return new ResponseEntity<>(userService.deleteUser(username, password), HttpStatus.ACCEPTED);
    }
}
