package com.geek.week8.question4;

//给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。
//
//
//
// 示例：
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//
//
// 提示：
//
//
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
// Related Topics 排序 数组

import java.util.TreeMap;

public class RelativeSortArray {

    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
            int i = 0;
            for (int n : arr2) {
                for (int j = 0; j < map.get(n); j++) {
                    arr1[i++] = n;
                }
                map.remove(n);
            }
            for (int n : map.keySet()) {
                for (int j = 0; j < map.get(n); j++) {
                    arr1[i++] = n;
                }
            }
            return arr1;
        }
    }

}
