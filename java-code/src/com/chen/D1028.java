package com.chen;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D1028 {
    // 求矩阵间数的和
    public static void main(String[] args) {
        int n, m, q;
        int[] sum = new int[1000010];
        List<QueryPair> query = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[(i - 1) * m + j] += sum[(i - 1) *m + j - 1] + scanner.nextInt();
            }
        }

        for (int i = 0; i < q; i++) {
            query.add(new QueryPair(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < q; i++) {
            int s = 0;
            QueryPair qp = query.get(i);
            int x1 = qp.getX1(), y1 = qp.getY1(), x2 = qp.getX2(), y2 = qp.getY2();
            for (int j = x1; j <= x2; j ++) {
                s += (sum[(j - 1) * m + y2] - sum[(j - 1) * m + y1 - 1]);
            }
            System.out.println(s);
        }

    }
    public static class QueryPair {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public QueryPair(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }

        public int getX2() {
            return x2;
        }

        public int getY2() {
            return y2;
        }
    }
}
