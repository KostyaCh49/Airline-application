package org.example.service;

import org.example.model.User;
import org.example.transport.dto.UserDTO;

import java.util.List;

public interface UserService {
    void create(User user);
    User getById(Long userId);
    List<UserDTO> getAll();
    User update(Long userId, User user);
    void delete(Long userId);
    void severalDatabaseChanges();
}
