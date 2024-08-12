package com.example.wishlist.repository;

import com.example.wishlist.model.AddressRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRequestRepository extends JpaRepository<AddressRequest, Long> {
}
