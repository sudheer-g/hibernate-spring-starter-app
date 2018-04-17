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

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User createUser(@ModelAttribute("user") User user) {
        System.out.println("Hit createUser");
        System.out.println(user.toString());
        return userService.create(user);
    }

    @GetMapping(value = "/{id:.+}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PutMapping(value = "/{id:.+}")
    public User editUser(@PathVariable("id") Integer id) {
        return userService.editUser(id);
    }

    @PostMapping(value = "/{id:.+}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }

}