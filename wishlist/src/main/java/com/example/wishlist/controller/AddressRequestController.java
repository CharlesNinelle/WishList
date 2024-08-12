package com.example.wishlist.controller;

import com.example.wishlist.model.AddressRequest;
import com.example.wishlist.model.User;
import com.example.wishlist.service.AddressRequestService;
import com.example.wishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address-requests")
public class AddressRequestController {

    private final AddressRequestService addressRequestService;
    private final UserService userService;

    @Autowired
    public AddressRequestController(AddressRequestService addressRequestService, UserService userService) {
        this.addressRequestService = addressRequestService;
        this.userService = userService;
    }

    @PostMapping("/request")
    public AddressRequest requestAddress(@RequestParam Long requesterId, @RequestParam Long recipientId) {
        User requester = userService.getUserById(requesterId);
        User recipient = userService.getUserById(recipientId);
        return addressRequestService.createAddressRequest(requester, recipient);
    }

    @PostMapping("/confirm")
    public AddressRequest confirmAddressRequest(@RequestParam Long requestId) {
        return addressRequestService.confirmAddressRequest(requestId);
    }

    @PostMapping("/decline")
    public AddressRequest declineAddressRequest(@RequestParam Long requestId) {
        return addressRequestService.declineAddressRequest(requestId);
    }
}
