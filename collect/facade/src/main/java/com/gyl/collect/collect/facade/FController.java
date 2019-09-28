package com.gyl.collect.collect.facade;

import com.gyl.collect.core.util.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@RestController
public class FController {

    @PostMapping("/workcollect/file/upload")
    public BaseResult fupload(MultipartHttpServletRequest request) {
        Map<String, MultipartFile> fileMap = request.getFileMap();
        fileMap.forEach((key, value) -> {
            String path = "/usr/upload/";
//            String path = "D:\\usr\\upload\\" ;
            File file = new File(path);
            OutputStream outputStream = null;
            try {
                if (!file.exists()) {
                    file.mkdirs();
                }
                outputStream = new FileOutputStream(new File(path + value.getOriginalFilename()));
                outputStream.write(value.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return new BaseResult();
    }
}
