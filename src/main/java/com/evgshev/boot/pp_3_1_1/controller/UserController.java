package com.evgshev.boot.pp_3_1_1.controller;


import com.evgshev.boot.pp_3_1_1.model.User;
import com.evgshev.boot.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

@GetMapping("/users")
public String showAllUsers(Model model) {
    List<User> allUsers = userService.getAllUsers();
    model.addAttribute("users", allUsers);
    return "user-list";
}

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }


    @PostMapping("/user-create")
    public String createUser(User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserId(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.addUser(user);
        return "redirect:/users";
    }
}
