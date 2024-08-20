package com.example.wishlist.controller;

import com.example.wishlist.model.AddressRequest;
import com.example.wishlist.service.AddressRequestService;
import com.example.wishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/address-requests")
public class AddressRequestController {

    private static final Logger logger = LoggerFactory.getLogger(AddressRequestController.class);

    private final AddressRequestService addressRequestService;

    @Autowired
    public AddressRequestController(AddressRequestService addressRequestService) {
        this.addressRequestService = addressRequestService;
    }

    @PostMapping("/create")
    public AddressRequest createAddressRequest(@RequestBody User requester, @RequestBody User recipient) {
        logger.info("Received request to create address request from {} to {}", requester.getEmail(), recipient.getEmail());
        return addressRequestService.createAddressRequest(requester, recipient);
    }

    @PostMapping("/confirm/{id}")
    public AddressRequest confirmAddressRequest(@PathVariable Long id) {
        logger.info("Received request to confirm address request with ID: {}", id);
        return addressRequestService.confirmAddressRequest(id);
    }

    @PostMapping("/decline/{id}")
    public AddressRequest declineAddressRequest(@PathVariable Long id) {
        logger.info("Received request to decline address request with ID: {}", id);
        return addressRequestService.declineAddressRequest(id);
    }
}
