package com.example.wishlist.service;

import com.example.wishlist.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email);
    User getUserById(Long id);
    void updateAddress(Long userId, String address);
}
