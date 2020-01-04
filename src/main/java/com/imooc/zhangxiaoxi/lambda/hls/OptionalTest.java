package com.imooc.zhangxiaoxi.lambda.hls;

import org.junit.Test;

import java.util.Optional;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link Optional}
 */
public class OptionalTest {

    /**
     * 三种创建optional对象方式
     */
    @Test
    public void test() {
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

    }
}
