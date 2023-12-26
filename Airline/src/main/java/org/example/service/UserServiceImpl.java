package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.transport.dto.UserDTO;
import org.example.transport.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::entityToDto)
                .toList();
    }

    @Override
    public User update(Long userId, User incomingUser) {
        User user = getById(userId);

        user.setUsername(incomingUser.getUsername());
        user.setPassword(incomingUser.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        User user = getById(userId);
        userRepository.delete(user);
    }
}
