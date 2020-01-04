package com.imooc.zhangxiaoxi.lambda.hls;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link List}
 */
public class ImmutableTest {
    public static void test(List<Integer> list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> c = Collections.unmodifiableList(list);
        test(c);
        System.out.println(c);
    }

    public void immutable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ImmutableSet set = ImmutableSet.copyOf(list);
    }
}
