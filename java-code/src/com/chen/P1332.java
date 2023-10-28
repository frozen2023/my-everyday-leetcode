package com.chen;

public class P1332 {

    public int removePalindromeSub(String s) {
        char[] chars = s.toCharArray();
        int begin = 0, end = chars.length - 1, ans = 0;
        for (int i = end; i >= begin; i--) {
            if (isHw(chars, begin, i)) {
                ans++;
                System.out.printf("%d次：end %d begin%d%n", ans, i, begin);
                begin = i + 1;
                i = end + 1;
            }
        }
        return ans;
    }

    public boolean isHw(char[] arr, int begin, int end) {
        int len = end - begin + 1;
        for (int i = begin; i < len >> 1; i++) {
            if (arr[i] != arr[end - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P1332().removePalindromeSub("baabb"));
    }
}
