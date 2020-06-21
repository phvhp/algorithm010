package com.geek.week2.question3;

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NAryTreePreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> ans = new ArrayList<Integer>();
            if (root == null) return ans;
            Deque<Node> deque = new ArrayDeque<Node>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                Node node = deque.pollFirst();
                ans.add(node.val);
                List<Node> children = node.children;
                if (children == null || children.size() <= 0) continue;
                for (int i = children.size() - 1; i >= 0; i--) {
                    deque.addFirst(children.get(i));
                }
            }
            return ans;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
