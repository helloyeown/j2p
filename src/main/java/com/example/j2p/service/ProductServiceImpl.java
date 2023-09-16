package com.example.j2p.service;

import org.springframework.stereotype.Service;

import com.example.j2p.dto.FileBoardListDTO;
import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final 

    @Override
    public PageResponseDTO<FileBoardListDTO> list(PageRequestDTO requestDTO) {
    }

    @Override
    public Long register(ProductDTO productDTO) {
    }
    
}
