package com.geek.week1.question3;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().new Solution().rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            if (len == 0 || k % len == 0) return;
            int i = 0, j = 0;
            int prev = nums[j];
            while (i < len) {
                j = (j + k) % len;
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
                i++;
            }
        }
    }
}
