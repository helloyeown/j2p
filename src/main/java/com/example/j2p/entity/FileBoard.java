package com.example.j2p.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FileBoard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @OneToMany  // 파일 보드가 여러 개의 이미지를 가짐
    private List<FileBoardImage> images;
    // 연관 관계 명시 안 하면 에러

}
