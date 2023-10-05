package com.chen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1324 {

        /*
        * 本题的思路就是用二维列表存储字母
        * 把每个子列表的长度都用空格填充到最长的单词长度（维护一个maxLen变量）
        * 最后取每个子列表第一个字符进行拼接，然后去掉最后的空格
        * */

        public static List<String> printVertically(String s) {
            List<List<Character>> list = new ArrayList<>();
            String[] words = s.split(" ");
            int maxLen = -1;
            for (String each : words) {
                char[] chars = each.toCharArray();
                if (chars.length > maxLen) {
                    maxLen = chars.length;
                }
                List<Character> inner = new ArrayList<>();
                for (char chr : chars) {
                    inner.add(chr);
                }
                list.add(inner);
            }
            for (List<Character> each : list) {
                if (each.size() < maxLen) {
                    int repeat = maxLen - each.size();
                    for (int i = 0; i < repeat; i++) {
                        each.add(' ');
                    }
                }
            }
            List<String> result = new ArrayList<>();
            for (int i = 0; i < maxLen; i++) {
                StringBuilder builder = new StringBuilder();
                for (List<Character> each : list) {
                    Character c = each.get(i);
                    builder.append(c);
                }
                String str = builder.toString();
                int j;
                for(j = str.length() - 1; j >= 0; j--) {
                    if (str.charAt(j) != ' ') {
                        break;
                    }
                }
                result.add(str.substring(0, j + 1));
            }
            return result;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        List<String> list = printVertically(next);
        System.out.println(list);
    }
}
