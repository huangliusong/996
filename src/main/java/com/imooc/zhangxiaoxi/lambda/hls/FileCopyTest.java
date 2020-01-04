package com.imooc.zhangxiaoxi.lambda.hls;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class FileCopyTest {
    @Test
    public static void main(String[] args) throws IOException {

        String originalUrl = "/Users/liusonghuang/Downloads/run.py";
        String targetUrl = "/Users/liusonghuang/Downloads/run1.py";


        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        inputStream = new FileInputStream(originalUrl);
        outputStream = new FileOutputStream(targetUrl);

        try {
            int content;
            while ((content = inputStream.read()) != -1) {
                outputStream.write(content);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
