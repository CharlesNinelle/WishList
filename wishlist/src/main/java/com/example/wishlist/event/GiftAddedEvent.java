package com.example.wishlist.event;

import com.example.wishlist.model.Gift;
import org.springframework.context.ApplicationEvent;

public class GiftAddedEvent extends ApplicationEvent {

    private final Gift gift;

    public GiftAddedEvent(Object source, Gift gift) {
        super(source);
        this.gift = gift;
    }

    public Gift getGift() {
        return gift;
    }
}
