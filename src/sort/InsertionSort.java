package sort;

//(1)算法简介
//插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
//它的工作原理是通过构建有序序列，对于未排序数据，
//在已排序序列中从后向前扫描，找到相应位置并插入。
//插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
//因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，
//为最新元素提供插入空间。
//
//(2)算法描述和实现
//一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
//
//<1>.从第一个元素开始，该元素可以认为已经被排序；
//<2>.取出下一个元素，在已经排序的元素序列中从后向前扫描；
//<3>.如果该元素（已排序）大于新元素，将该元素移到下一位置；
//<4>.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
//<5>.将新元素插入到该位置后；
//<6>.重复步骤2~5。

//(3)算法分析
//        最佳情况：输入数组按升序排列。T(n) = O(n)
//        最坏情况：输入数组按降序排列。T(n) = O(n^2)
//        平均情况：T(n) = O(n^2)
public class InsertionSort {
    public static void insertSort(int[] array) {
        long start = System.nanoTime();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int current = array[i];
            int st = 0;
            int en = i - 1;
            while (st<=en){
                int mid = (st+en)>>1;
                if(array[mid]<array[i]){
                    st = mid+1;
                }else {
                    en = mid-1;
                }
            }
            for (int j = i-1; j >=st ; j--) {
                array[j+1]=array[j];
            }
            array[st]=current;
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1000.0+"ms");

        for (int j = 0; j < array.length; j++) {
            System.out.printf(array[j]+" ");
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertSort(array);
    }
}
