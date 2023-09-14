package com.example.j2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j2p.entity.FileBoard;
import com.example.j2p.repository.search.FileBoardSearch;

public interface FileBoardRepository extends JpaRepository<FileBoard, Long>, FileBoardSearch {
    
}
