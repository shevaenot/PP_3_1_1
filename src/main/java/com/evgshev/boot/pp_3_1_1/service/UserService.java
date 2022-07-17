package com.evgshev.boot.pp_3_1_1.service;


import com.evgshev.boot.pp_3_1_1.dao.UserDAO;
import com.evgshev.boot.pp_3_1_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserId(int id) {
        return userDAO.getOne(id);
    }

    public void addUser(User user) {
        userDAO.save(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteById(id);
    }

}
