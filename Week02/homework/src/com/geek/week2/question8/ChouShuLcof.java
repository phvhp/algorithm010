package com.geek.week2.question8;

//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
// Related Topics 数学

public class ChouShuLcof {

    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
    }

    class Solution {
        public int nthUglyNumber(int n) {
            int[] uglyNums = new int[n];
            uglyNums[0] = 1;
            int a = 0, b = 0, c = 0;
            for (int i = 1; i < n; i++) {
                int ai = 2 * uglyNums[a];
                int bi = 3 * uglyNums[b];
                int ci = 5 * uglyNums[c];
                int min = Math.min(Math.min(ai, bi), ci);
                uglyNums[i] = min;
                if (ai <= min) a++;
                if (bi <= min) b++;
                if (ci <= min) c++;
            }
            return uglyNums[n - 1];
        }
    }


}
