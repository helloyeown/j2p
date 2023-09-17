package com.example.j2p.service;

import com.example.j2p.dto.FileBoardListDTO;
import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductDTO;
import com.example.j2p.dto.ProductListDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
    
    PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO);

    Long register(ProductDTO productDTO);

}
