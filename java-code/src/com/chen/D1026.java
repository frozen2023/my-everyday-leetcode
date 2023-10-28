package com.chen;


import java.util.Scanner;

public class D1026 {
    public static Pair<Integer, Integer> myBinarySort(int[] p, int target, int l, int r) {
        int left = -2, right = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (p[mid] == target) {
                left = mid;
                right = mid;
                while(right <= r && p[right] == target)
                    right ++;
                while (left >= l && p[left] == target)
                    left --;
                break;
            } else if (p[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new Pair<>(left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, q;
        int[] arr = new int[100010];
        int[] query = new int[10010];
        n = scanner.nextInt();
        q = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            query[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            Pair<Integer, Integer> result = myBinarySort(arr, query[i], 0, n - 1);
            System.out.printf("%d %d\n", result.getKey(), result.getValue());
        }
    }

    // 实现一个
    public static class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }
}
