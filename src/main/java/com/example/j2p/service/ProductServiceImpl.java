package com.example.j2p.service;

import org.springframework.stereotype.Service;

import com.example.j2p.dto.FileBoardListDTO;
import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductDTO;
import com.example.j2p.dto.ProductListDTO;
import com.example.j2p.entity.Product;
import com.example.j2p.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO) {

        return repository.list(requestDTO);

    }

    @Override
    public Long register(ProductDTO productDTO) {

        Product product = Product.builder()
            .pname(productDTO.getPname())
            .pdesc(productDTO.getPdesc())
            .price(productDTO.getPrice()).build();

        productDTO.getImages().forEach(image -> {
            product.addImage(image);
        });

        return repository.save(product).getPno();

    }

    @Override
    public ProductDTO readOne(Long pno) {

        Product product = repository.selectOne(pno);

        ProductDTO dto = ProductDTO.builder()
            .pno(product.getPno())
            .pname(product.getPname())
            .pdesc(product.getPdesc())
            .price(product.getPrice())
            .images(product.getImages().stream().map(pi -> pi.getFname()).toList())
            .build();

        return dto;

    }
    
}
