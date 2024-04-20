package com.hibernate.demo.controller;

import com.hibernate.demo.model.User;
import com.hibernate.demo.model.UserDto;
import com.hibernate.demo.service.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{userId}")
    public User get(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @PostMapping("/create")
    public void create(@RequestBody  UserDto userDto) {
        userService.create(userDto);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}
