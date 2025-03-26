package com.contactmanager.contactmanager.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.helpers.ResourceNotFoundException;
import com.contactmanager.contactmanager.repository.UserRepo;
import com.contactmanager.contactmanager.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean saveUser(User user) {
        //generate userId
        user.setUserId(java.util.UUID.randomUUID().toString());
        userRepo.save(user);
        return true;
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        //update user2 with user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProvider(user.getProvider());
        return Optional.of(userRepo.save(user2));
    }

    @Override
    public void deleteUser(String userId) {
        User user2 = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2 != null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
