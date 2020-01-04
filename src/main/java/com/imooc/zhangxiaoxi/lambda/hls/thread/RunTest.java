package com.imooc.zhangxiaoxi.lambda.hls.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class RunTest {

    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService =
                Executors.newCachedThreadPool();

        Future<Integer> task = executorService.submit(() -> {
            Thread.sleep(1000L * 10);
            return 1 * 22;
        });


        Integer s = task.get();
        System.out.println(s);

    }

    @Test
    public void executeTest() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(() -> {
            try {
                Thread.sleep(1000L * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer num = 2 * 5;
            System.out.println("执行结果:" + num);
        });

        Thread.sleep(1000L*100);
    }
}
