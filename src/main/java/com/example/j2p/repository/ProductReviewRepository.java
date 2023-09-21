package com.example.j2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j2p.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    
}
