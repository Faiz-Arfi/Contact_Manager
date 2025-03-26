package com.contactmanager.contactmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.contactmanager.contactmanager.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    //add custom methods here
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
