package com.controllers;


import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.services.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("com.services.UserService")
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("Hit createUser");
        System.out.println(user.toString());
        return userService.create(user);
    }

    @GetMapping(value = "/{id:.+}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PutMapping(value = "/{id:.+}")
    public User editUser(@PathVariable("id") Integer id, @RequestBody User user) {
        user.setUserId(id);
        return userService.update(user);
    }

    @PostMapping(value = "/{id:.+}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        User deleted = userService.delete(id);
        return deleted != null;
    }

}