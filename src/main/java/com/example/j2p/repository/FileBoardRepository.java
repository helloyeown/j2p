package com.example.j2p.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.j2p.entity.FileBoard;
import com.example.j2p.repository.search.FileBoardSearch;

public interface FileBoardRepository extends JpaRepository<FileBoard, Long>, FileBoardSearch {
    
    @EntityGraph(attributePaths = {"images"})   // EntityGraph: 한 번에 로딩하고 싶을 때
    @Query("select b from FileBoard b where b.bno = :bno")
    FileBoard selectOne(@Param("bno") Long bno);

}
