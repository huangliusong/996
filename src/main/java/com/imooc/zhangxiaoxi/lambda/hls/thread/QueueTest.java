package com.imooc.zhangxiaoxi.lambda.hls.thread;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class QueueTest {

    @Test
    public void testArrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        new Thread(() -> {
            try {
               while (true){
                   queue.take();
                   Thread.sleep(1000);
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列添加值" + i);
        }


    }


}
