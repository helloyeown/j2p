package com.example.j2p.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.ProductDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductServiceTests {
    
    @Autowired
    private ProductService service;

    @Test
    public void getListTest(){

        log.info(service.list(new PageRequestDTO(1, 10)));        

    }

    @Test
    public void registerTest(){

        List<String> images = new ArrayList<>();

        images.add("aaa.jpg");
        images.add("bbb.jpg");

        ProductDTO dto = ProductDTO.builder()
            .pname("service Test")
            .pdesc("test")
            .price(8500)
            .images(images)
            .build();

        service.register(dto);

    }

    @Test
    public void readTest(){

        log.info(service.readOne(1L));

    }

}
