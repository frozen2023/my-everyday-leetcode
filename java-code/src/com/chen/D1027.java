package com.chen;


import java.util.Scanner;

public class D1027 {
    // 求三次方根
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n;
        n = scanner.nextDouble();
        double l = -10000, r = 10000;
        while (r - l > 1e-8) {
            double mid = (r + l) / 2;
            System.out.println(mid);
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%6f", l);

    }
}
