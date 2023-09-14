package com.example.j2p.repository.search;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.j2p.dto.FileBoardListDTO;
import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.entity.FileBoard;
import com.example.j2p.entity.QFileBoard;
import com.example.j2p.entity.QFileBoardImage;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileBoardSearchImpl extends QuerydslRepositorySupport implements FileBoardSearch {

    public FileBoardSearchImpl() {
        super(FileBoard.class);
    }

    @Override
    public PageResponseDTO<FileBoardListDTO> list(PageRequestDTO requestDTO) {

        QFileBoard board = QFileBoard.fileBoard;
        QFileBoardImage boardImage = QFileBoardImage.fileBoardImage;

        JPQLQuery<FileBoard> query = from(board);
        query.leftJoin(board.images, boardImage);   // board.images를 boardImage로 처리
        query.where(boardImage.ord.eq(0));  // ord 0번 이미지만 가져옴

        int pageNum = requestDTO.getPage() - 1 < 0 ? 0 : requestDTO.getPage() - 1;
        // pageNum 값이 음수가 나오는 문제를 삼항연산자로 방지
        Pageable pageable = PageRequest.of(pageNum, requestDTO.getSize(), Sort.by("bno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        JPQLQuery<FileBoardListDTO> listQuery = query.select(Projections.bean(FileBoardListDTO.class,
            board.bno, board.title, boardImage.uuid, boardImage.fname));

        List<FileBoardListDTO> list = listQuery.fetch();
        Long totalCount = listQuery.fetchCount();
        log.info(list);

        return new PageResponseDTO<>(list, totalCount, requestDTO);

    }
    
    

}
