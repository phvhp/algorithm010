package com.geek.week4.question11;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找

public class findMinimumInRotatedSortedArray {

    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            int result = nums[0];
            while (l < r) {
                int mid = (l + r) / 2;
                if (l == mid) {
                    if (result > nums[l]) {
                        result = nums[l];
                    } else if (result > nums[r]) {
                        result = nums[r];
                    }
                    return result;
                }
                if (nums[l] < nums[mid]) {
                    if (result > nums[l]) {
                        result = nums[l];
                    }
                    l = mid + 1;
                } else {
                    if (result > nums[mid]) {
                        result = nums[mid];
                    }
                    r = mid - 1;
                }
            }
            if (l == r) {
                if (result > nums[l]) {
                    result = nums[l];
                }
            }
            return result;
        }
    }

}
