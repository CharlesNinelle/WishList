package com.example.wishlist.service;

import com.example.wishlist.exception.ResourceNotFoundException;
import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        logger.info("Registering user with email: {}", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        logger.debug("User registered successfully with ID: {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User loginUser(String email) {
        logger.info("Logging in user with email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user != null) {
            logger.debug("User logged in successfully with email: {}", email);
        } else {
            logger.warn("User login failed for email: {}", email);
        }
        return user;
    }

    @Override
    public User getUserById(Long id) {
        logger.info("Fetching user with ID: {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", id);
                    return new ResourceNotFoundException("User not found with id: " + id);
                });
    }

    public void updateAddress(Long userId, String address) {
        User user = getUserById(userId);
        user.setAddress(address);
        user.setAddressConfirmed(false);
        userRepository.save(user);
        logger.info("Updated address for user with ID: {}", userId);
    }
}
