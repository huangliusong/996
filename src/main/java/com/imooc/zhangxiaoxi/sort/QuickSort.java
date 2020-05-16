package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/15
 * {@link }
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 8, 34, 78, 3};
        QuickSortFun(arr, 0, arr.length - 1);
        for (int k = 0; k < arr.length; k++) {
            System.out.print("  " + arr[k]);
        }
    }

    public static void QuickSortFun(int A[], int low, int high) {
        if (low<high){
            int pivot = Partition(A, low, high);
            QuickSortFun(A, low, pivot - 1);
        }
        for (int k = 0; k < A.length; k++) {
            System.out.print("  " + A[k]);
        }
    }

    private static int Partition(int[] A, int low, int high) {
        int pivot = A[low];
        while (low < high & A[high] >= pivot) --high;
        A[low] = A[high];
        while (low < high && A[low] <= pivot) ++low;
        A[high] = A[low];
        A[low] = pivot;
        return low;
    }


}
