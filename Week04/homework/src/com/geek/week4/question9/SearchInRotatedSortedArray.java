package com.geek.week4.question9;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 示例 1:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//
//
// 示例 2:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
// Related Topics 数组 二分查找

public class SearchInRotatedSortedArray {

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length <= 0) {
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while(r > l) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (l == mid) {
                    if (nums[r] == target) {
                        return r;
                    }
                    return -1;
                }
                if (nums[mid] > nums[l]) {
                    if (nums[mid] > target && nums[l] <= target) {
                        if (nums[l] == target) {
                            return l;
                        }
                        l = l + 1;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && nums[r] >= target) {
                        if (nums[r] == target) {
                            return r;
                        }
                        l = mid + 1;
                        r = r - 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            if (target == nums[l]) {
                return l;
            }
            return -1;
        }
    }

}
