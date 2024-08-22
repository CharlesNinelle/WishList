package com.example.wishlist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AddressRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User requester;  // User requesting address // Пользователь, запрашивающий адрес

    @ManyToOne
    private User recipient; // User whose address is being requested // Пользователь, чей адрес запрашивается

    private boolean confirmed; // Approved or rejected // Подтверждено или отклонено
}
