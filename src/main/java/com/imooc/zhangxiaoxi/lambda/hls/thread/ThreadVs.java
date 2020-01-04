package com.imooc.zhangxiaoxi.lambda.hls.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class ThreadVs {

    /**
     * 老的处理
     */
    @Test
    public void oldHandler() throws InterruptedException {
        /**
         * 将word转成pdf格式，处理时长很长的耗时过程
         */
        for (int request = 1; request <= 100; request++) {
            new Thread(() -> {
                System.out.println("文档处理开始!");
                try {
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束!");
            }).start();
        }
        Thread.sleep(1000L * 1000);
    }

    /**
     * 新的处理
     */
    @Test
    public void newHandler() throws InterruptedException {
        //thread pool init
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int request = 1; request <= 100; request++) {
            executorService.execute(() -> {
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            });
        }
        Thread.sleep(1000L * 1000);
    }

}
