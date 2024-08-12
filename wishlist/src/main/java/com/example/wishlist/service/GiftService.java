package com.example.wishlist.service;

import com.example.wishlist.model.Gift;

import java.util.List;

public interface GiftService {
    List<Gift> getGiftsByUserId(Long userId);
    Gift addGift(Gift gift);
}
