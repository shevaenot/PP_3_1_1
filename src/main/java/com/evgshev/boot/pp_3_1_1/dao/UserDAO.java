package com.evgshev.boot.pp_3_1_1.dao;



import com.evgshev.boot.pp_3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

}
