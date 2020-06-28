package com.geek.week3.question3;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            combine(n, 1, k, new ArrayList<Integer>(), ans);
            return ans;
        }

        private void combine(int n, int begin, int k, List<Integer> levelList, List<List<Integer>> ans) {
            if (levelList.size() == k) {
                List<Integer> list = new ArrayList<Integer>(levelList);
                ans.add(list);
                return;
            }

            for (int i = begin; i <= n; i++) {
                levelList.add(i);
                combine(n, i + 1, k, levelList, ans);
                levelList.remove(new Integer(i));
            }
        }
    }
}
