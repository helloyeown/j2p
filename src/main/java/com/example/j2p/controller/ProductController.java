package com.example.j2p.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductDTO;
import com.example.j2p.dto.ProductListDTO;
import com.example.j2p.service.ProductService;
import com.example.j2p.util.FileUploader;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/products")
@Log4j2
public class ProductController {
    
    private final ProductService service;
    private final FileUploader uploader;

    // 목록
    @GetMapping("/list")
    public PageResponseDTO<ProductListDTO> getList(PageRequestDTO requestDTO){

        return service.list(requestDTO);

    }

    // 등록
    @PostMapping("/")
    public Map<String, Long> register(@RequestBody ProductDTO dto){

        log.info(dto);

        List<String> fileNames = uploader.uploadFiles(dto.getFiles(), true);
        dto.setImages(fileNames);

        Long pno = service.register(dto);

        return Map.of("result", pno);

    }

    // 조회
    @GetMapping("/{pno}")
    public ProductDTO readOne(@PathVariable("pno") Long pno){

        return service.readOne(pno);

    }

}
