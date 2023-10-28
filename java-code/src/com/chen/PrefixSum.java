package com.chen;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrefixSum {
    public static final int N = 100010;
    // 前缀和
    public static void main(String[] args) {
        int n, m;
        int[] sum = new int[N];
        List<Pair<Integer, Integer>> query = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum[i] = scanner.nextInt();
            } else {
                sum[i] = sum[i - 1] + scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            query.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < m; i++) {
            Pair<Integer, Integer> item = query.get(i);
            int l = item.getKey(), r = item.getValue();
            System.out.println(sum[r] - sum[l - 1]);
        }
    }
}
