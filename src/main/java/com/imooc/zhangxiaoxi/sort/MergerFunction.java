package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/16
 * {@link }
 */
public class MergerFunction {
    private static Integer[] B = new Integer[8];

    public static void main(String[] args) {
        Integer[] A = new Integer[]{49, 38, 65, 97, 76, 13, 27};
        MergeSort(A, 0, 6);
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }

    //这个一个递归算法
    public static void MergeSort(Integer A[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(A, low, mid);
            MergeSort(A, mid + 1, high);
            Merger(A, low, mid, high);
        }
    }

    public static void Merger(Integer[] A, int low, int mid, int high) {
        int i, j, k;
        for (k = low; k <= high; k++) {
            B[k] = A[k];//把A中的元素全部复制到B
        }
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            //把B中到元素进行比较，把小到元素放到A中k作为下标
            if (B[i] < B[j]) {
                A[k] = B[i++];
            } else {
                A[k] = B[j++];
            }
        }//end for
        while (i <= mid) {
            A[k++] = B[i++];
        }
        while ((j <= high)) {
            A[k++] = B[j++];
        }
    }

}
