package com.chen;


import java.util.Scanner;

public class D1025 {

     /*
     实现快速排序，采用分治的思想
     先选定一个基准数，然后把比基准数小的放在左边，比基准数大的放在右边
     然后递归的对左右两边进行排序  递归的终止条件是 left >= right
     */

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j --;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i ++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void myQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 取出基准数
        int k = arr[left];
        int i = left, j = right;
        // 将比k小的数移到左边，大的数移到右边
        while (i < j) {
            while (i < j && arr[j] >= k)
                j --;
            arr[i] = arr[j];
            while (i < j && arr[i] <= k)
                i ++;
            arr[j] = arr[i];
        }
        arr[i] = k;
        myQuickSort(arr, left, i - 1);
        myQuickSort(arr, i + 1, right);
    }

    /* 获取逆序对的个数
    * 逆序对的个数 = 左边的逆序对的个数 + 右边的逆序对的个数 + 左右两边组成的逆序对的个数
    * 利用分治的思想，先求左右两边的逆序对的个数，然后再求左右两边组成的逆序对的个数
    * 求分布在左右两边的逆序对数量时，
    * 当右半边的数小于左半边的数时，右半边的数与左半边的数后面的所有数都可以构成逆序对
    * 即 mid - i + 1
     */
    public static int getReversePair(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (right + left) >> 1;
        int leftCount = getReversePair(arr, left, mid);
        int rightCount = getReversePair(arr, mid + 1, right);
        int count = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i ++;
            } else {
                count += mid - i + 1;
                j ++;
            }
        }
        return count + leftCount + rightCount;
    }



    public static void main(String[] args) {
        int n, k;
        int[] arr = new int[100010];
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        myQuickSort(arr, 0, n - 1);
        System.out.println(arr[k - 1]);
    }

}
