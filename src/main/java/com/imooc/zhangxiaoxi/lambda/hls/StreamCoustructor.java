package com.imooc.zhangxiaoxi.lambda.hls;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link Stream}
 */
public class StreamCoustructor {

    @Test
    public void streamFromvalue() {
        Stream stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }


    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4};
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);
    }

    @Test
    public void streamFromfile() throws IOException {
        Stream<String> stringStream = Files.lines(Paths.get("/Users/liusonghuang/Downloads/run.py"));
        stringStream.forEach(System.out::println);
    }


    @Test
    public void streamFromFunction() {
        Stream stream = Stream.iterate(0, n -> n + 2);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromFunction1() {

        Stream stream = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);
    }

}
