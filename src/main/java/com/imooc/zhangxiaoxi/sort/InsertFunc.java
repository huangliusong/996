package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/17
 * {@link }
 */
public class InsertFunc {

    public static void main(String[] args) {
        Integer[] A = new Integer[]{49, 38, 65, 97, 76, 13, 27};
        InsertSort(A, 6);
        for (int i = 1; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }

    public static void InsertSort(Integer A[], int n) {
        int i, j, low, high, mid;
        for (i = 2; i <= n; i++) {
            A[0] = A[i];
            low = 1;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (A[mid] > A[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i - 1; j >= high + 1; --j) {
                A[j + 1] = A[j];
            }
            A[high + 1] = A[0];
        }
    }
}
