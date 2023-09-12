package com.example.j2p.repository;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.j2p.entity.FileBoard;
import com.example.j2p.entity.FileBoardImage;

import jakarta.transaction.Transactional;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class FileBoardRepositoryTests {
    
    @Autowired
    private FileBoardRepository repository;

    // 등록
    @Test
    public void insertTest(){

        for(int i=0; i<100; i++){

            FileBoard board = FileBoard.builder()
                .title("insert test" + i)
                .writer("user" + i%10)
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

    @Test
    @Transactional
    public void readTest(){

        Optional<FileBoard> result = repository.findById(8L);

        FileBoard board = result.orElseThrow();

        log.info(board);

    }

}
