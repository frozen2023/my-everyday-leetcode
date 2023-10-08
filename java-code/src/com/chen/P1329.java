package com.chen;

public class P1329 {

    /*
    * 对每个对角线进行冒泡排序
    *
    * */

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < Math.min(m, n) - 1; i++) {
            for (int j = 0; j < m - 1; j++)
                for (int k = 0; k < n - 1; k++) {
                    if (mat[j][k] > mat[j + 1][k + 1]) {
                        int t = mat[j][k];
                        mat[j][k] = mat[j + 1][k + 1];
                        mat[j + 1][k + 1] = t;
                    }
                }
        }
        return mat;
    }
}
