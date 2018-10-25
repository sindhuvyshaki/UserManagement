package com.um.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.um.Management.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer>{

}
