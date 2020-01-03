package com.imooc.zhangxiaoxi.lambda.hls;

import java.io.FileNotFoundException;

/**
 * @author huangliusong
 * @since 2020/1/3
 * {@link }
 */
@FunctionalInterface
public interface FileConsumer {

    void fileHandler(String fileContent);

}
