package com.example.wishlist.event;

import com.example.wishlist.model.Wishlist;
import org.springframework.context.ApplicationEvent;

public class WishlistCreatedEvent extends ApplicationEvent {

    private final Wishlist wishlist;

    public WishlistCreatedEvent(Object source, Wishlist wishlist) {
        super(source);
        this.wishlist = wishlist;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }
}
