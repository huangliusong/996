package com.imooc.zhangxiaoxi.lambda.hls;

import java.io.*;

/**
 * @author huangliusong
 * @since 2020/1/3
 * {@link }
 */
public class FileService {

    /**
     * 文件操作handler
     * @param url
     * @param fileConsumer
     * @throws IOException
     */
    public void fileHandler(String url, FileConsumer fileConsumer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line + "\n");
        }
        fileConsumer.fileHandler(stringBuffer.toString());
    }

}
