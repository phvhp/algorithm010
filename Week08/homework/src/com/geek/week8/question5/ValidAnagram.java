package com.geek.week8.question5;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (t == s) return true;
            if (t == null || s == null) return false;
            char[] cs = s.toCharArray();
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (char c : cs) {
                Integer count = map.getOrDefault(c, 0);
                map.put(c, ++count);
            }
            for (char c : t.toCharArray()) {
                Integer count = map.getOrDefault(c, 0);
                count--;
                if (count < 0) return false;
                if (count == 0) {
                    map.remove(c);
                    continue;
                }
                map.put(c, count);
            }
            return map.size() == 0;
        }
    }

}
