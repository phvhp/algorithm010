package com.geek.week5.question5;

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//
// 示例 1:
//
//
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
//
//
// 示例 2:
//
//
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
//
//
// 注意:
//
//
// 输入的字符串长度不会超过1000。
//
// Related Topics 字符串 动态规划

import java.util.*;

public class PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            int N = s.length(), ans = 0;
            for (int center = 0; center <= 2 * N - 1; ++center) {
                int left = center / 2;
                int right = left + center % 2;
                while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                }
            }
            return ans;
        }
    }
}
