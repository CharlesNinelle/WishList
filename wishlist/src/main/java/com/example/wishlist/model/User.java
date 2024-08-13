package com.example.wishlist.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    private boolean addressConfirmed;  // Flag to confirm the address // Флаг для подтверждения адреса

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wishlist> wishlists;

    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<AddressRequest> sentAddressRequests;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<AddressRequest> receivedAddressRequests;
}
