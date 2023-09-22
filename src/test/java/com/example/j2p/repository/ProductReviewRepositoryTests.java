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

        Long[] pnoArr = {106L, 103L, 102L, 100L, 98L};

        for(Long pno : pnoArr){

            int score = (int)(Math.random() * 5) + 1;

            Product product = Product.builder().pno(pno).build();
    
            for(int i=0; i<100; i++){
    
                ProductReview review = ProductReview.builder()
                    .content("repository insert test" + i)
                    .reviewer("user" + i%10)
                    .score(score)
                    .product(product)
                    .build();
    
                repository.save(review);
    
            }
        }
    }

}
