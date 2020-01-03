package com.imooc.zhangxiaoxi.lambda.hls;

import com.alibaba.fastjson.JSON;
import com.imooc.zhangxiaoxi.lambda.cart.CartService;
import com.imooc.zhangxiaoxi.lambda.cart.Sku;
import com.imooc.zhangxiaoxi.lambda.cart.SkuCategoryEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author huangliusong
 * @since 2020/1/3
 * {@link }
 */
public class StreamVs1 {
    /**
     * 原始实现
     */
    @Test
    public void odlCartHandle() {


        //print
        List<Sku> cartSkuList = CartService.getCartSkuList();
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        //filter
        List<Sku> notBooksSkuList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
                notBooksSkuList.add(sku);
            }
        }

        //两个最贵,sort
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                if (o1.getTotalPrice() > o2.getTotalPrice()) {
                    return -1;
                } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });


        List<Sku> top2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            top2.add(notBooksSkuList.get(i));
        }


        //计算总价
        Double money = 0.0;
        for (Sku sku : top2) {
            money += sku.getTotalPrice();
        }

        //获取两件商品都名称
        List<String> resultNameList = new ArrayList<String>();
        for (Sku sku : top2) {
            resultNameList.add(sku.getSkuName());
        }


        System.out.println(
                JSON.toJSONString(resultNameList, true));
        System.out.println("商品总价" + money);
    }

    /**
     * 流实现
     */
    @Test
    public void newHandler() {
        AtomicReference<Double> money = new AtomicReference<Double>(Double.valueOf(0.0));
        List<String> carNameList = CartService.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2)
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());

        System.out.println(
                JSON.toJSONString(carNameList, true));
        System.out.println("商品总价" + money.get());
    }


    @Test
    public void newCartHandle() {
        AtomicReference<Double> money =
                new AtomicReference<>(Double.valueOf(0.0));

        List<String> resultSkuNameList =
                CartService.getCartSkuList()
                        .stream()
                        /**
                         * 1 打印商品信息
                         */
                        .peek(sku -> System.out.println(
                                JSON.toJSONString(sku, true)))
                        /**
                         * 2 过滤掉所有图书类商品
                         */
                        .filter(sku -> !SkuCategoryEnum.BOOKS.equals(
                                sku.getSkuCategory()))
                        /**
                         * 排序
                         */
                        .sorted(Comparator.
                                comparing(Sku::getTotalPrice).reversed())
                        /**
                         * TOP2
                         */
                        .limit(2)

                        /**
                         * 累加商品总金额
                         */
                        .peek(sku -> money.set(money.get() + sku.getTotalPrice()))

                        /**
                         * 获取商品名称
                         */
                        .map(sku -> sku.getSkuName())

                        /**
                         * 收集结果
                         */
                        .collect(Collectors.toList());


        /**
         * 打印输入结果
         */
        System.out.println(
                JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价：" + money.get());
    }
}
