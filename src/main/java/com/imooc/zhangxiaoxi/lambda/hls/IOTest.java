package com.imooc.zhangxiaoxi.lambda.hls;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class IOTest {


    @Test
    public void copyFile() throws IOException {
        //创建source和sink
        CharSource charSource =
                Files.asCharSource(new File("/Users/liusonghuang/Downloads/run.py"), Charsets.UTF_8);
        CharSink charSink =
                Files.asCharSink(new File("/Users/liusonghuang/Downloads/run1.py"), Charsets.UTF_8);


        //拷贝
        //charSource.copyTo(charSink);

        String immutableList= charSource.read();
        System.out.println(immutableList);
    }

}
