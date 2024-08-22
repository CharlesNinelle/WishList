package com.example.wishlist.event;

import com.example.wishlist.model.AddressRequest;
import org.springframework.context.ApplicationEvent;

public class AddressRequestSentEvent extends ApplicationEvent {

    private final AddressRequest addressRequest;

    public AddressRequestSentEvent(Object source, AddressRequest addressRequest) {
        super(source);
        this.addressRequest = addressRequest;
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }
}
