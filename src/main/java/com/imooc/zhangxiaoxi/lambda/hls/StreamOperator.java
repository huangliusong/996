package com.imooc.zhangxiaoxi.lambda.hls;

import com.alibaba.fastjson.JSON;
import com.imooc.zhangxiaoxi.lambda.cart.CartService;
import com.imooc.zhangxiaoxi.lambda.cart.Sku;
import com.imooc.zhangxiaoxi.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangliusong
 * @since 2020/1/3
 * {@link }
 */
public class StreamOperator {
    List<Sku> list;

    @Before
    public void inti() {
        list = CartService.getCartSkuList();
    }

    /**
     * filter使用：过滤掉不符合断言判断等数据
     */
    @Test
    public void filterTest() {

        list.stream()
                //filter
                .filter(sku ->
                        SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }


    /**
     * 将一个元素转化为另一个元素
     */
    @Test
    public void mapTest() {
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }


    /**
     * 对象转成一个流
     */
    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }


    @Test
    public void peekTest() {
        list.stream()
                .peek(sku -> {
                    System.err.println(sku.getSkuName());
                })
                .forEach(item -> System.out.println(JSON.toJSONString(item)));

    }


    @Test
    public void sortTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .forEach(item -> System.out.println(JSON.toJSONString(item)));


    }


    @Test
    public void distinctTest() {
        list.stream()
                .map(sku -> sku.getSkuCategory())
                //distinct
                .distinct()
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }


    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }


    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(2*3)
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }


}
