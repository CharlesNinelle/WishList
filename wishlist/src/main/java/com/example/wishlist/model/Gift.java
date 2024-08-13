package com.example.wishlist.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String url;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "wishlist_id")  // Associates a gift with a specific wishlist // Связывает подарок с конкретным списком желаемого
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Associates the gift with the user if needed // Связывает подарок с пользователем, если это необходимо
    private User user;
}
