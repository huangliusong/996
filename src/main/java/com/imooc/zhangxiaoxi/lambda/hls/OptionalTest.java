package com.imooc.zhangxiaoxi.lambda.hls;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link Optional}
 */
public class OptionalTest {

    public static void stream(List<String> list) {
//        list.stream()
//                .forEach(System.out::println);

        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        stream(Arrays.asList("1","2"));
    }

    /**
     * 三种创建optional对象方式
     */
    @Test
    public void test() throws Throwable {
        //创建空都optional对象
        Optional.empty();
        //使用非null值创建optional对象
        Optional.of("huangliusong");
        //使用任意值创建optional对象
        Optional optional = Optional.ofNullable("huangliusong");
        /**
         * 判断是否引用缺失的方法
         */
        boolean l = optional.isPresent();
        System.out.println(l);
        //ifPresent
        //存在时
        optional.ifPresent(System.out::println);


        //引用缺失
        optional.orElse("引用缺失");
        optional.orElseGet(() -> {
            return "tewt";
        });

        optional.orElseThrow(() -> {
            throw new RuntimeException("引用一次");
        });

    }
}
