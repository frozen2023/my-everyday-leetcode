package com.chen;

public class P1326 {

    /*
    * 本题的解题思路是贪心算法（虽然看答案之前啥也不会）
    * 先维护一个rightMost数组，代表从某个水龙头开始最远能覆盖到的水龙头
    * 通过遍历ranges不断更新每一个点的最远位置
    * 然后遍历rightMost，通过pre和last变量，分别代表当前
    * 区间的左端和右端，在 i < pre时不断更新last使之最大,
    * i == pre时就代表要使用 pre -> last这个新的区间了
    * 同时答案+1，并更新pre=last
    * */

    public int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            rightMost[left] = Math.max(right, rightMost[left]);
        }

        int pre = 0, last = 0, result = 0;

        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);

            if (last == i) {
                return -1;
            }

            if (i == pre) {
                result ++;
                pre = last;
            }
        }

        return result;

    }
}
