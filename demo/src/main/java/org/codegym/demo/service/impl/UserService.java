package org.codegym.demo.service.impl;

import org.codegym.demo.entity.User;
import org.codegym.demo.repository.UserRepository;
import org.codegym.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean loginStatus(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) return false;
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) throws RuntimeException {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


}
