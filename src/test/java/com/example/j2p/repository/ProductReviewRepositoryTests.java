package com.example.j2p.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.j2p.entity.Product;
import com.example.j2p.entity.ProductReview;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductReviewRepositoryTests {
    
    @Autowired
    private ProductReviewRepository repository;

    @Test
    public void insertTest(){

        Product product = Product.builder().pno(1L).build();

        ProductReview review = ProductReview.builder()
            .content("repository insert test")
            .reviewer("user")
            .score(5)
            .product(product)
            .build();

        repository.save(review);

    }

}
