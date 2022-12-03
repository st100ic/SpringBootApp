package com.alexandr.demo.repos;

import com.alexandr.demo.domain.Message;
import com.alexandr.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
