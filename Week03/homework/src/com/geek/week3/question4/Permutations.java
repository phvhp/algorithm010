package com.geek.week3.question4;

import java.util.ArrayList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            permute(nums, new ArrayList<Integer>(), ans);
            return ans;
        }

        private void permute(int[] nums, List<Integer> list, List<List<Integer>> ans) {
            if (nums.length == list.size()) {
                List<Integer> result = new ArrayList<Integer>(list);
                ans.add(result);
                return;
            }

            for (int i : nums) {
                if (!list.contains(i)) {
                    list.add(i);
                    permute(nums, list, ans);
                    list.remove(new Integer(i));
                }
            }
        }
    }
}
