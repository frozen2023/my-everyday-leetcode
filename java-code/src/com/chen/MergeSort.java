package com.chen;

public class MergeSort {

    // 写一个归并排序
    public static void myMergeSort(int[] arr, int left, int right) {
        // 递归终止条件
        if (left >= right) {
            return;
        }
        int mid = (right + left) >> 1;
        // 分治
        myMergeSort(arr, left, mid);
        myMergeSort(arr, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        // 合并
        while (i <= mid && j <= right) {
            temp[k ++] = arr[i] < arr[j] ? arr[i ++] : arr[j ++];
        }
        while (i <= mid) {
            temp[k ++] = arr[i ++];
        }
        while (j <= right) {
            temp[k ++] = arr[j ++];
        }
        // 将temp中的元素复制到arr中
        System.arraycopy(temp, 0, arr, left + 0, temp.length);
    }


    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 6, 5};
        myMergeSort(arr, 0, 4);
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
