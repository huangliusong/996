package com.imooc.zhangxiaoxi.lambda.hls;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 编译器自动生成了try-finally的结构
 *
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class NewFileCopyTest {

    /**
     * try-with-resource
     */
    @Test
    public void copyFile() {
        String originalUrl = "/Users/liusonghuang/Downloads/run.py";
        String targetUrl = "/Users/liusonghuang/Downloads/run1.py";

        //初始化输入/输出对象
        try (
                FileInputStream fileInputStream = new FileInputStream(originalUrl);
                FileOutputStream fileOutputStream = new FileOutputStream(targetUrl);
        ) {
            int content;
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
