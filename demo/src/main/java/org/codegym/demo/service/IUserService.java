package org.codegym.demo.service;

import org.codegym.demo.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);
    void deleteUser(User user);
    User findById(long id);
    User findByUsername(String username);
    boolean loginStatus(String username, String password);
    List<User> findAllUsers();
}
