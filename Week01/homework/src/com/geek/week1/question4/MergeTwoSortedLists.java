package com.geek.week1.question4;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        Solution solution = mergeTwoSortedLists.new Solution();
        ListNode node = solution.mergeTwoLists(mergeTwoSortedLists.toLinkedList(new int[]{1, 2, 4}), mergeTwoSortedLists.toLinkedList(new int[]{1, 3, 4}));
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) System.out.print(" -> ");
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode node = dummy;
            while (l1 != null || l2 != null) {
                Integer v1 = l1 != null ? l1.val : null;
                Integer v2 = l2 != null ? l2.val : null;
                if (v1 == null) {
                    node.next = l2;
                    l2 = l2.next;
                } else if (v2 == null) {
                    node.next = l1;
                    l1 = l1.next;
                } else if (v1 <= v2) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
                node = node.next;
            }
            return dummy.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode toLinkedList(int[] nums) {
        if (nums == null || nums.length <= 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int i = 0; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        return dummy.next;
    }
}
