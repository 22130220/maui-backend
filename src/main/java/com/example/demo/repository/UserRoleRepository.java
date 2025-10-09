package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole , Integer> {
    List<UserRole> findByUserID(User userID);
}
