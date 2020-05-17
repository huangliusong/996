package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/17
 * {@link }
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] A = new Integer[]{49, 38, 65, 97, 76, 13, 27};
        InsertSortFun(A, 6);
        for (int i = 1; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }

    public static void InsertSortFun(Integer A[], int n) {
        int i, j;
        for (i = 2; i <= n; i++) {//依次将A[2]～A[n]插入到前面已排序序列
            if (A[i] < A[i - 1]) {
                A[0] = A[i];//复制为哨兵：A[0]；
                for (j = i - 1; A[0] < A[j]; --j) {
                    A[j + 1] = A[j];
                }
                A[j + 1] = A[0];
            }
        }

    }
}
