package com.geek.week9.question1;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串

public class FirstUniqueCharacterInAString {

    class Solution {
        public int firstUniqChar(String s) {
            int[] chars = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                chars[c - 'a'] += 1;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (chars[c - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
