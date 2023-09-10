package com.example.j2p.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.j2p.entity.FileBoard;
import com.example.j2p.entity.FileBoardImage;

@SpringBootTest
public class FileBoardRepositoryTests {
    
    @Autowired
    private FileBoardRepository repository;

    @Test
    public void insertTest(){

        FileBoard board = FileBoard.builder()
            .title("insert test")
            .writer("user")
            .content("test")
            .build();

        FileBoardImage img1 = FileBoardImage.builder()
            .uuid(UUID.randomUUID().toString())
            .fname("AAA.jpg")
            .build();

        FileBoardImage img2 = FileBoardImage.builder()
            .uuid(UUID.randomUUID().toString())
            .fname("BBB.jpg")
            .build();

        board.addImage(img1);
        board.addImage(img2);

        repository.save(board);

    }

}
