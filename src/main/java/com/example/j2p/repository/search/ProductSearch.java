package com.example.j2p.repository.search;

import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductListDTO;

public interface ProductSearch {
    
    PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO);

}
