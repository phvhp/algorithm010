package com.geek.week9.question2;

//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例:
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
//
//
//
// 提示：
//
//
// 该字符串只包含小写英文字母。
// 给定字符串的长度和 k 在 [1, 10000] 范围内。
//
// Related Topics 字符串

public class ReverseStringII {
    class Solution {
        public String reverseStr(String s, int k) {
            int i = 0;
            int len = s.length();
            int j = (2 * k <= len) ? 2 * k : len;
            StringBuilder ans = new StringBuilder();
            while (j <= len) {
                if (j - i > k) {
                    StringBuilder kstr = new StringBuilder(s.substring(i, i + k));
                    kstr.reverse();
                    ans.append(kstr);
                    ans.append(s.substring(i + k, j));
                } else {
                    StringBuilder kstr = new StringBuilder(s.substring(i, j));
                    kstr.reverse();
                    ans.append(kstr);
                }
                if (j == len) break;
                i = j;
                j = j + 2 * k <= len ? j + 2 * k : len;
            }
            return ans.toString();
        }
    }
}
