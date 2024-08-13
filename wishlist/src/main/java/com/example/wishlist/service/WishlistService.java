package com.example.wishlist.service;

import com.example.wishlist.model.Wishlist;
import java.util.List;

public interface WishlistService {
    Wishlist createWishlist(Wishlist wishlist);
    Wishlist getWishlistById(Long id);
    List<Wishlist> getWishlistsByUserId(Long userId);
    void updateWishlist(Wishlist wishlist);
    void deleteWishlist(Long id);
}
