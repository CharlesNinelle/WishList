package com.example.wishlist.service;

import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishlistRepository;
import com.example.wishlist.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private static final Logger logger = LoggerFactory.getLogger(WishlistServiceImpl.class);

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Wishlist createWishlist(Wishlist wishlist) {
        logger.info("Creating new wishlist with name: {}", wishlist.getName());
        Wishlist savedWishlist = wishlistRepository.save(wishlist);
        logger.debug("Wishlist created successfully with ID: {}", savedWishlist.getId());
        return savedWishlist;
    }

    @Override
    public Wishlist getWishlistById(Long id) {
        logger.info("Fetching wishlist with ID: {}", id);
        return wishlistRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Wishlist not found with ID: {}", id);
                    return new ResourceNotFoundException("Wishlist not found with id: " + id);
                });
    }

    @Override
    public List<Wishlist> getWishlistsByUserId(Long userId) {
        logger.info("Fetching wishlists for user ID: {}", userId);
        return wishlistRepository.findByUserId(userId);
    }

    @Override
    public void updateWishlist(Wishlist wishlist) {
        logger.info("Updating wishlist with ID: {}", wishlist.getId());
        wishlistRepository.save(wishlist);
    }

    @Override
    public void deleteWishlist(Long id) {
        logger.info("Deleting wishlist with ID: {}", id);
        wishlistRepository.deleteById(id);
    }
}
