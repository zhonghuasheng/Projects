package com.zhonghuasheng.ms.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import sun.security.action.GetPropertyAction;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;

@Slf4j
public class FileUtil {

    /**
     * 将前端传过来的文件转换为file类型
     * @param multipartFile
     * @return
     */
    public static File transferToFile(MultipartFile multipartFile) {
        File file = null;
        try {
            File tmpdir = new File(AccessController.doPrivileged(new GetPropertyAction("java.io.tmpdir")));
            file = new File(tmpdir, multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error("文件转换失败，e={}", e);
        }

        // 获取文件的地方需要考虑在使用后是否删除 file.deleteOnExit();
        return file;
    }
}
