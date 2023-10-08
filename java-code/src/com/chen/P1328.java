package com.chen;

public class P1328 {

    /*
    * 遍历 len >> 1 (字符串长度 / 2)
    * 如果表示'a'就替换成a
    * 如果全是a，就把最后一个替换成b
    * */

    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 1) {
            return "";
        }

        int j;
        for (j = 0; j < (len >> 1); j++) {
            if (palindrome.charAt(j) != 'a') {
                return palindrome.replaceFirst(palindrome.charAt(j) + "", "a");
            }
        }

        return palindrome.substring(0, len - 1) + "b";
    }


    public static void main(String[] args) {
        System.out.println(new P1328().breakPalindrome("a"));
    }
}
