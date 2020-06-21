package com.geek.week2.question4;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String s : strs) {
                char[] cs = s.toCharArray();
                Arrays.sort(cs);
                String sortedStr = new String(cs);
                if (map.get(sortedStr) == null) map.put(sortedStr, new ArrayList<String>());
                map.get(sortedStr).add(s);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }

}