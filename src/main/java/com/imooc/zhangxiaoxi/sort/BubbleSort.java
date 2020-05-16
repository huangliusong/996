package com.imooc.zhangxiaoxi.sort;

/**
 * 冒泡排序
 * @author huangliusong
 * @since 2020/5/15
 * {@link }
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,4,1,8,34,78,3};
        sort(arr,arr.length);
    }


    public static void sort(int[] A,int n){
        //从1-n
        for (int i=0;i<n;i++){
             //i-j交换元素，冒泡
            for (int j=n-1;j>i;j--){
                //判断值的大小
                if(A[j]<A[j-1]){
                    int temp=A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                }
            }
        }
       for (int k=0;k<n;k++){
           System.out.print("  "+A[k]);
       }
    }
}
