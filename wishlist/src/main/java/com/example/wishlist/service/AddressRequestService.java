package com.example.wishlist.service;

import com.example.wishlist.model.AddressRequest;
import com.example.wishlist.model.User;
import com.example.wishlist.repository.AddressRequestRepository;
import com.example.wishlist.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressRequestService {

    private final AddressRequestRepository addressRequestRepository;

    @Autowired
    public AddressRequestService(AddressRequestRepository addressRequestRepository) {
        this.addressRequestRepository = addressRequestRepository;
    }

    public AddressRequest createAddressRequest(User requester, User recipient) {
        AddressRequest request = new AddressRequest();
        request.setRequester(requester);
        request.setRecipient(recipient);
        request.setConfirmed(false);
        return addressRequestRepository.save(request);
    }

    public AddressRequest confirmAddressRequest(Long requestId) {
        AddressRequest request = addressRequestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + requestId));
        request.setConfirmed(true);
        return addressRequestRepository.save(request);
    }

    public AddressRequest declineAddressRequest(Long requestId) {
        AddressRequest request = addressRequestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + requestId));
        request.setConfirmed(false);
        return addressRequestRepository.save(request);
    }
}
