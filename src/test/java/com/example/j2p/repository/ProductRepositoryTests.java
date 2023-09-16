package com.example.j2p.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.entity.Product;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductRepositoryTests {
    
    @Autowired
    private ProductRepository repository;

    @Test
    public void getListTest(){

        log.info(repository.list(new PageRequestDTO(1, 10)));

    }

    @Test
    public void registerTest(){

        for(int i=0; i<100; i++){

            Product product = Product.builder()
                .pname("test name" + i)
                .pdesc("test" + i)
                .writer("user" + i%10)
                .price(8000)
                .build();

            product.addImage(UUID.randomUUID().toString() + "aaa.jpg");
            product.addImage(UUID.randomUUID().toString() + "bbb.jpg");

        repository.save(product);

        }

    }

}
