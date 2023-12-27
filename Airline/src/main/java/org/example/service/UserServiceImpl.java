package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.transport.dto.UserDTO;
import org.example.transport.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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
