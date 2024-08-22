package com.example.wishlist.controller;

import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/create")
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        logger.info("Received request to create wishlist with name: {}", wishlist.getName());
        return wishlistService.createWishlist(wishlist);
    }

    @GetMapping("/{id}")
    public Wishlist getWishlistById(@PathVariable Long id) {
        logger.info("Received request to get wishlist with ID: {}", id);
        return wishlistService.getWishlistById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUser(@PathVariable Long userId) {
        logger.info("Received request to get wishlists for user with ID: {}", userId);
        return wishlistService.getWishlistsByUserId(userId);
    }

    @PutMapping("/update")
    public void updateWishlist(@RequestBody Wishlist wishlist) {
        logger.info("Received request to update wishlist with ID: {}", wishlist.getId());
        wishlistService.updateWishlist(wishlist);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWishlist(@PathVariable Long id) {
        logger.info("Received request to delete wishlist with ID: {}", id);
        wishlistService.deleteWishlist(id);
    }
}
