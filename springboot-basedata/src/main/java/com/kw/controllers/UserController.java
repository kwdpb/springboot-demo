package com.kw.controllers;

import com.kw.model.User;
import com.kw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("getUser")
    public String login(){

        List<User> userList = userService.getUser();
        return "success";
    }
}
