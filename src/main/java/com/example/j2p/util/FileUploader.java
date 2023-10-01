package com.example.j2p.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

@Component  // 빈 등록
@Log4j2
public class FileUploader {

    // custom exception
    public static class UploadException extends RuntimeException{   // class
        public UploadException(String msg){     // 생성자
            super(msg);
        }
    }
    
    @Value("${com.example.upload.path}")    // application.properties에서 값을 가져옴
    private String path;

    public List<String> uploadFiles(List<MultipartFile> files, boolean makeThumbnail){

        if(files == null || files.size() == 0){
            throw new UploadException("No File");
        }

        List<String> uploadFileNames = new ArrayList<>();

        log.info("path: " + path);
        log.info(files);

        for(MultipartFile file : files){

            String originalFileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();

            String saveFileName = uuid + "_" + originalFileName;
            File saveFile = new File(path, saveFileName);

            // auto close
            try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(saveFile)){
                
                FileCopyUtils.copy(in, out);

                if(makeThumbnail){
                    File thumbFile = new File(path, "s_" + saveFileName);
                    Thumbnailator.createThumbnail(saveFile, thumbFile, 200, 200);
                }

            uploadFileNames.add(saveFileName);

            } catch (Exception e) {
                throw new UploadException("Upload Fail: " + e.getMessage());
            } 

        }

        return uploadFileNames;

    }

    // 파일 삭제(DB에선 삭제하지 않고 업로드만)
    public void deleteFiles(List<String> fileNames){

        if(fileNames == null || fileNames.size() == 0){
            return;
        }

        // 예외 처리 때문에 람다식 사용x
        for (String fname : fileNames) {
            // 원본, 썸네일
            File original = new File(path, fname);
            File thumb = new File(path, "s_" + fname);

            if(thumb.exists()){
                thumb.delete();
            }

            original.delete();
        }
    }

}
