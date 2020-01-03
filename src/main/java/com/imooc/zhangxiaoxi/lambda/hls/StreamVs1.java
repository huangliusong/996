package com.imooc.zhangxiaoxi.lambda.hls;

import com.alibaba.fastjson.JSON;
import com.imooc.zhangxiaoxi.lambda.cart.CartService;
import com.imooc.zhangxiaoxi.lambda.cart.Sku;

import java.util.List;

/**
 * @author huangliusong
 * @since 2020/1/3
 * {@link }
 */
public class StreamVs1 {
    /**
     * 原始实现
     */
    public void odlCartHandle() {


        List<Sku> cartSkuList = CartService.getCartSkuList();
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }
    }
}
