package com.imooc.zhangxiaoxi.lambda.file;

import com.imooc.zhangxiaoxi.lambda.hls.FileService;
import org.junit.Test;

import java.io.IOException;

/**
 * @author huangliusong
 * @since 2020/1/3
 * {@link }
 */
public class Tes5 {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();
        fileService.fileHandler("/Users/liusonghuang/Downloads/run.py",
                fileContent -> {
            System.err.println(fileContent);
        });
    }

}
