package com.geek.week1.question5;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针


import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(nums, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (nums1_copy[i] <= nums2[j]) {
                    nums1[i + j] = nums1_copy[i++];
                } else {
                    nums1[i + j] = nums2[j++];
                }
            }
            if (i < m) {
                System.arraycopy(nums1_copy, i, nums1, i + j, m - i);
            }
            if (j < n) {
                System.arraycopy(nums2, j, nums1, i + j, n - j);
            }
        }
    }

}
