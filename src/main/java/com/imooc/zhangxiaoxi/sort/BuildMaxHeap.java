package com.imooc.zhangxiaoxi.sort;

/**
 * @author huangliusong
 * @since 2020/5/16
 * {@link }
 */
public class BuildMaxHeap {

    public static void main(String[] args) {
        Integer[] A = new Integer[]{0, 53, 17, 78, 9, 45, 65, 87, 32};
        //BuildMaxH(A, 8);
        HeadSort(A, 8);
    }

    public static void BuildMaxH(Integer A[], Integer len) {
        //
        for (Integer i = len / 2; i > 0; i--) {
            //从n/2～1反复调整堆
            AdjustDown(A, i, len);
        }
    }

    public static void AdjustDown(Integer A[], Integer k, Integer len) {

        //将元素k向下进行调整
        A[0] = A[k];
        for (Integer i = 2 * k; i <= len; i *= 2) {
            if (i < len && A[i] < A[i + 1]) {
                i++;//取key较大的子结点下标
            }
            if (A[0] >= A[i]) {
                break;//筛选结束
            } else {
                A[k] = A[i];// 将A[i]调整到双亲结点上
                k = i;//修改k值，以便继续向下筛选
            }
        } //end for
        A[k] = A[0];//被筛选结点的值放入最终位置


        for (Integer p = 1; p <= len; p++) {
            //System.out.print("  " + A[p]);
        }
        //System.out.println();
    }

    public static void HeadSort(Integer[] A, Integer len) {
        BuildMaxH(A, len);//初始化建堆
        for (Integer i = len; i >= 1; i--) {
            Swap(A, i, 1);
            System.err.print("  " + A[i]);
            AdjustDown(A, 1, i - 1);
        }
    }

    private static void Swap(Integer[] A, Integer i, Integer i1) {
        Integer temp = A[i];
        A[i] = A[i1];
        A[i1] = temp;
    }

}
