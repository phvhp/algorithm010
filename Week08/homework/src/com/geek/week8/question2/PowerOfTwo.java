package com.geek.week8.question2;

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学

public class PowerOfTwo {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            while (n % 2 == 0 && n != 0) {
                n >>= 1;
            }
            return n == 1;
        }
    }
}
