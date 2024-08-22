package com.example.wishlist.event;

import com.example.wishlist.model.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserLoginEvent extends ApplicationEvent {

    private final User user;

    public UserLoginEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

}
