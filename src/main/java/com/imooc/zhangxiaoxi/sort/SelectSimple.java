package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/16
 * {@link }
 */
public class SelectSimple {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 8, 0, 34, 78, 3};

        SelectSort(arr,arr.length);
    }

    private  static void SelectSort(int A[], int n) {
        //对表A做简单对选择排序，A[]从0开始存放元素
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
        for (int k=0;k<n;k++){
            System.out.print("  "+A[k]);
        }


    }
}
