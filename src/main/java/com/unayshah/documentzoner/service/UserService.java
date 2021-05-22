package com.unayshah.documentzoner.service;

import com.unayshah.documentzoner.dao.User;
import com.unayshah.documentzoner.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(String username, String password) {
        if (!userRepository.findById(username).isPresent())
            return userRepository.save(new User(username, password));
        else
            return null;
    }

    public Boolean deleteUser(String username, String password) {
        if (userRepository.checkUserCredentials(username, password).isPresent()) {
            userRepository.deleteById(username);
            return true;
        }
        return false;
    }
}
