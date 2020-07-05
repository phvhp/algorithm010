package com.geek.week4.question10;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
// 示例 1:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//
//
// 示例 2:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
// Related Topics 数组 二分查找

public class SearchA2dMatrix {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length <= 0) return false;
            int rs = 0, re = matrix.length - 1;
            while (rs < re) {
                int mid = (rs + re) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] < target) {
                    if (matrix[mid][matrix[mid].length - 1] < target) {
                        rs = mid + 1;
                    } else {
                        rs = mid;
                        break;
                    }

                } else {
                    if (matrix[mid][matrix[mid].length - 1] > target) {
                        re = mid - 1;
                    } else {
                        rs = mid;
                        break;
                    }
                }
            }
            int[] row = matrix[rs];
            int cs = 0, ce = row.length - 1;
            while (cs <= ce) {
                int mid = (cs + ce) / 2;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] < target) {
                    cs = mid + 1;
                } else {
                    ce = mid - 1;
                }
            }
            return false;
        }
    }
}
