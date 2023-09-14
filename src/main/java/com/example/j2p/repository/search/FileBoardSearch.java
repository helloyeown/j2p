package com.example.j2p.repository.search;

import org.springframework.data.domain.Page;

import com.example.j2p.dto.FileBoardListDTO;
import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;

public interface FileBoardSearch {

    PageResponseDTO<FileBoardListDTO> list(PageRequestDTO requestDTO);
    
}
