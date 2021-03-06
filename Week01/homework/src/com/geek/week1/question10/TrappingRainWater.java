package com.geek.week1.question10;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

public class TrappingRainWater {

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length <= 1) return 0;
            int len = height.length;
            int[] maxLefts = new int[len];
            int[] maxRigths = new int[len];
            maxLefts[0] = height[0];
            maxRigths[len - 1] = height[len - 1];
            for (int i = 1; i < len - 1; i++) {
                maxLefts[i] = Math.max(maxLefts[i - 1], height[i]);
            }
            for (int i = len - 2; i > 0; i--) {
                maxRigths[i] = Math.max(maxRigths[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 1; i < len - 1; i++) {
                ans += Math.min(maxLefts[i], maxRigths[i]) - height[i];
            }
            return ans;
        }
    }

}
