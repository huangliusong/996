package com.imooc.zhangxiaoxi.lambda.hls;

import com.alibaba.fastjson.JSON;
import com.imooc.zhangxiaoxi.lambda.cart.CartService;
import com.imooc.zhangxiaoxi.lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
public class StreamCollector {

    @Test
    public void toList() {
        List<Sku> list = CartService.getCartSkuList();
        List list1 = list.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list1));
    }


    @Test
    public void group() {
        List<Sku> list = CartService.getCartSkuList();
        Map<Object, List<Sku>> map = list.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        System.out.println(JSON.toJSONString(map, true));
    }

    @Test
    public void partition() {
        List<Sku> list = CartService.getCartSkuList();
        Map<Boolean, List<Sku>> map = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));

        System.out.println(JSON.toJSONString(map, true));
    }


}
