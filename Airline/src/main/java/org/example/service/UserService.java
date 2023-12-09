package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    User getById(Long userId);
    List<User> getAll();
    User update(Long userId, User user);
    void delete(Long userId);
}