package com.geek.week9.question7;

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
//输入: "aba"
//输出: True
//
//
// 示例 2:
//
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串

public class ValidPalindromeII {

    class Solution {
        public boolean validPalindrome(String s) {
            int len = s.length();
            if (len == 0) {
                return false;
            }
            int count = 1;
            int head = 0;
            int tail = len - 1;
            while (head < tail) {
                char a = s.charAt(head);
                char b = s.charAt(tail);
                if (a == b) {
                    head++;
                    tail--;
                } else {
                    boolean flag = true;
                    for (int i = head; i < tail; i++) {
                        if (s.charAt(i) != s.charAt(tail - 1 - (i - head))) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        flag = true;
                        for (int i = head + 1; i <= tail; i++) {
                            if (s.charAt(i) != s.charAt(tail - (i - (head + 1)))) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    return flag;
                }
            }
            return true;
        }
    }

}
