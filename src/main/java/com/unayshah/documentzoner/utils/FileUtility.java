package com.unayshah.documentzoner.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtility {
    
    public static File MultipartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File("documentzoner/src/main/resources/static/" + multipartFile.getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }
        return file;
    }
}
