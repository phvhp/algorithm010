package com.geek.week5.question3;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划

import java.util.Arrays;

public class MaximalSquare {

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int max = 0;
            int m = matrix.length;
            if (m == 0) {
                return 0;
            }
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        if (i > 0 && j > 0) {
                            int w = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                            dp[i][j] += w;
                        }
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
            return max * max;
        }
    }

}
