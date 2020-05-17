package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/17
 * {@link }
 */
public class ShellSort {
    public static void main(String[] args) {
        Integer[] A = new Integer[]{49, 38, 65, 97, 76, 13, 27};
        ShellSort(A, 6);
        for (int i = 1; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }

    public static void ShellSort(Integer A[], int n) {
        int i, dk, j;
        for (dk = n / 2; dk >= 1; dk = dk / 2) {
            for (i = dk + 1; i <= n; ++i) {
                if (A[i] < A[i - dk]) {
                    A[0] = A[i];
                    for (j = i - dk; j > 0 && A[0] < A[j]; j -= dk) {
                        A[j + dk] = A[j];
                    }
                    A[j + dk] = A[0];
                }
            }
        }
    }
}
