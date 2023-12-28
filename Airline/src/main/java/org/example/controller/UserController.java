package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.example.transport.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/transactional")
    public void severalDatabaseChanges() {
        userService.severalDatabaseChanges();
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/get/{userId}")
    public User getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @GetMapping("/get")
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @PutMapping("/update/{userId}")
    public User update(@PathVariable Long userId, @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}
