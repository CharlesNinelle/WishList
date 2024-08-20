package com.example.wishlist.controller;

import com.example.wishlist.model.Gift;
import com.example.wishlist.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    private static final Logger logger = LoggerFactory.getLogger(GiftController.class);

    private final GiftService giftService;

    @Autowired
    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping("/user/{userId}")
    public List<Gift> getGiftsByUser(@PathVariable Long userId) {
        logger.info("Received request to get gifts for user with ID: {}", userId);
        return giftService.getGiftsByUserId(userId);
    }

    @PostMapping("/add")
    public Gift addGift(@RequestBody Gift gift) {
        logger.info("Received request to add gift with title: {}", gift.getTitle());
        return giftService.addGift(gift);
    }
}
