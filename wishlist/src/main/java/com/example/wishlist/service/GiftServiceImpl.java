package com.example.wishlist.service;

import com.example.wishlist.model.Gift;
import com.example.wishlist.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class GiftServiceImpl implements GiftService {

    private static final Logger logger = LoggerFactory.getLogger(GiftServiceImpl.class);

    private final GiftRepository giftRepository;

    @Autowired
    public GiftServiceImpl(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @Override
    public List<Gift> getGiftsByUserId(Long userId) {
        logger.info("Fetching gifts for user ID: {}", userId);
        List<Gift> gifts = giftRepository.findByUserId(userId);
        if (gifts.isEmpty()) {
            logger.warn("No gifts found for user ID: {}", userId);
        } else {
            logger.debug("Found {} gifts for user ID: {}", gifts.size(), userId);
        }
        return gifts;
    }

    @Override
    public Gift addGift(Gift gift) {
        logger.info("Adding new gift with title: {}", gift.getTitle());
        Gift savedGift = giftRepository.save(gift);
        logger.debug("Gift added successfully with ID: {}", savedGift.getId());
        return savedGift;
    }
}
