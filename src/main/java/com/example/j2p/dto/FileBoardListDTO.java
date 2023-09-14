package com.example.j2p.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FileBoardListDTO {
    
    private Long bno;
    private String title;
    private String uuid;
    private String fname;

}
