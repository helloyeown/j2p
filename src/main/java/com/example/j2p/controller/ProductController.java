package com.example.j2p.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductListDTO;
import com.example.j2p.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService service;

    @GetMapping("/list")
    public PageResponseDTO<ProductListDTO> getList(PageRequestDTO requestDTO){

        return service.list(requestDTO);

    }

}
