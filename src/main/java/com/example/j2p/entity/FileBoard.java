package com.example.j2p.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "images")
public class FileBoard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    
    private String title;

	private String content;

	private String writer;

    // 연관 관계 명시 안 하면 에러
    @OneToMany  // 파일 보드가 여러 개의 이미지를 가짐
    @JoinColumn(name = "board") // 이미지가 보드에 소속되는 종속 관계를 맺어줌
    @Builder.Default
    private List<FileBoardImage> images = new ArrayList<>();
    // 처음부터 new로 만들어서 해당 객체를 계속 가리키도록 초기화해서 관리함
    // -> 새로 컬렉션 추가하면 절대 안 됨
    // 이미지의 crud도 보드가 관리 -> 하위 엔티티까지 한 번에 save 가능

    public void addImage(FileBoardImage image){
        image.changeOrd(images.size());
        images.add(image);
    }

}
