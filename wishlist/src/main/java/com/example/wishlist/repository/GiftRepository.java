package com.example.wishlist.repository;

import com.example.wishlist.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, Long> {
    List<Gift> findByUserId(Long userId);
}
