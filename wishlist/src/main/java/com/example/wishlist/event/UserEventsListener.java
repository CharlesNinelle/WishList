package com.example.wishlist.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventsListener {

    private static final Logger logger = LoggerFactory.getLogger(UserEventsListener.class);

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        logger.info("New user registered: {}", event.getUser().getEmail());
        // Дальнейшая обработка, например, отправка приветственного письма
    }

    @EventListener
    public void handleUserLoginEvent(UserLoginEvent event) {
        logger.info("User logged in: {}", event.getUser().getEmail());
        // Дальнейшая обработка, например, запись входа в лог
    }
}
