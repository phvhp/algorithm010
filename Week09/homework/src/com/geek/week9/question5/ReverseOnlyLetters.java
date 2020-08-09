package com.geek.week9.question5;

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//
//
//
// 示例 1：
//
// 输入："ab-cd"
//输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串

import java.util.HashMap;
import java.util.Map;

public class ReverseOnlyLetters {

    class Solution {
        public String reverseOnlyLetters(String S) {
            int len = S.length();
            char[] chars = new char[len];
            int i = 0, j = len - 1;
            while (i <= j) {
                if (!isLetter(S.charAt(i))) {
                    chars[i] = S.charAt(i);
                    i++;
                    continue;
                }
                if (!isLetter(S.charAt(j))) {
                    chars[j] = S.charAt(j);
                    j--;
                    continue;
                }
                chars[i] = S.charAt(j);
                chars[j] = S.charAt(i);
                i++;
                j--;
            }
            return new String(chars);
        }

        private boolean isLetter(char c) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                return true;
            }
            return false;
        }
    }

}
