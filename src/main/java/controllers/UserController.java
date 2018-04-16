package controllers;


import models.User;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
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