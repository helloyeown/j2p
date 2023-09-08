package com.example.j2p.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FileBoardImage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgno;

    private String uuid;

    private String fname;

    private int ord;    // 파일 등록 순서(대표이미지)

    public void changeOrd(int ord){
        this.ord = ord;
    }

}
