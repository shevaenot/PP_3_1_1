package com.evgshev.boot.pp_3_1_1.controller;


import com.evgshev.boot.pp_3_1_1.model.User;
import com.evgshev.boot.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ipi")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

@GetMapping("/users")
public List<User> showAllUsers(Model model) {
    List<User> allUsers = userService.getAllUsers();
    model.addAttribute("users", allUsers);
    return allUsers;
}

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUserId(id);

        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {

        userService.addUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.addUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getUserId(id);


        userService.deleteUser(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
