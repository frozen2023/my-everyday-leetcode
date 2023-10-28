package com.chen;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighPrecisionCalculator {

    // 高精度加法
    public static List<Integer> add(List<Integer> n1, List<Integer> n2) {
        int t = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= Math.max(n1.size() - 1, n2.size() - 1); i ++) {
            if (i < n1.size()) t += n1.get(i);
            if (i < n2.size()) t += n2.get(i);
            result.add(t % 10);
            t /= 10;
        }
        if (t == 1) {
            result.add(1);
        }
        return result;
    }

    // 高精度减法
    public static List<Integer> sub(List<Integer> n1, List<Integer> n2) {
        // 借位
        int i, t;
        List<Integer> result = new ArrayList<>();
        for (i = 0, t = 0; i < n1.size(); i++) {
            t = n1.get(i) - t;
            if (i < n2.size()) t -= n2.get(i);
            result.add((t + 10) % 10);
            // 处理借位
            t = t >= 0 ? 0 : 1;
        }
        // 处理前导0
        if (result.size() > 1) {
            int r = result.size() - 1;
            while (result.get(r).equals(0)) {
                r--;
                if (r == 0) {
                    break;
                }
            }
            result = result.subList(0, r + 1);
        }
        return result;
    }

    // 比较n1 >= n2
    public static boolean compare(List<Integer> n1, List<Integer> n2) {
        if (n1.size() != n2.size()) {
            return n1.size() - n2.size() > 0;
        }
        for (int i = 0; i < n1.size(); i++) {
            if (!n1.get(i).equals(n2.get(i))) {
                return n1.get(i) > n2.get(i);
            }
        }
        return true;
    }

    // 高精度乘法 （高 * 低）
    // 本位 = t % 10 进位 = t / 10
    public static List<Integer> mul(List<Integer> l, int n) {
        // 进位
        int t = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l.size() || t > 0; i++) {
            if (i < l.size()) {
                t += l.get(i) * n;
            }
            result.add(t % 10);
            t /= 10;
        }
        return result;
    }

    // 高精度除法
    // 本位 = (余数 * 10 + 数组值) / 除数   余数 = 本位 % 除数
    public static List<Integer> div(List<Integer> l, int n) {
        int t = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            t = t * 10 + l.get(i);
            result.add(t / n);
            t = t % n;
        }
        // 去除前导0
        int r = 0;
        if (result.size() > 1) {
            while (result.get(r).equals(0)) {
                r++;
                if (r == result.size() - 1) break;
            }
        }
        result = result.subList(r, result.size());
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = len1 - 1; i >= 0; i --) {
            l1.add(num1.charAt(i) - '0');
        }
        for (int i = len2 - 1; i >= 0; i --) {
            l2.add(num2.charAt(i) - '0');
        }
        //List<Integer> result = add(l1, l2);
        List<Integer> result;
        if (compare(l1, l2)) {
            result = sub(l1, l2);
        } else {
            result = sub(l2, l1);
        }
        if (!compare(l1, l2))
            System.out.print("-");
        for (int i = result.size() - 1; i >= 0; i --) {
            System.out.print(result.get(i));
        }
    }

}
