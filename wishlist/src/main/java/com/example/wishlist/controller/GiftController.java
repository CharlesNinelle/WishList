package com.example.wishlist.controller;

import com.example.wishlist.model.Gift;
import com.example.wishlist.service.GiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    private final GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping("/user/{userId}")
    public List<Gift> getGiftsByUser(@PathVariable Long userId) {
        return giftService.getGiftsByUserId(userId);
    }

    @PostMapping("/add")
    public Gift addGift(@RequestBody Gift gift) {
        return giftService.addGift(gift);
    }
}
