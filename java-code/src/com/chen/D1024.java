package com.chen;

import java.util.*;

public class D1024 {

    /*
    * 采用离散化的思想
    * 先把每一行的元素去重，然后排序
    * 然后对每一行的元素进行二分查找
    * 映射到从1开始的连续的整数
    * */
    public static void main(String[] args) {
        int t, n;
        List<List<Integer>> row = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                inner.add(scanner.nextInt());
            }
            row.add(inner);
        }
        for (List<Integer> each : row) {
            ArrayList<Integer> newList = new ArrayList<>(new HashSet<>(new ArrayList<>(each)));
            Collections.sort(newList);
            for (Integer item : each) {
                System.out.printf("%d ", binarySearch(newList, item) + 1);
            }
            System.out.println();
        }
    }

    // 二分查找
    public static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, mid;
        while (left <= right) {
            // 无符号右移 /2 得到左边的整数
            mid = (left + right) >> 1;
            if (list.get(mid).equals(target)) {
                return mid;
            } else if (list.get(mid).compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
