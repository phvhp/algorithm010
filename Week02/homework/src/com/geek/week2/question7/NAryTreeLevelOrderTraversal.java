package com.geek.week2.question7;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }

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
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if (root == null) return ans;
            List<Node> levelNodes = new ArrayList<Node>();
            levelNodes.add(root);
            levelOrder(levelNodes, ans);
            return ans;
        }

        private void levelOrder(List<Node> levelNodes, List<List<Integer>> ans) {
            if (levelNodes == null || levelNodes.size() <= 0) return;
            List<Integer> levelVals = new ArrayList<Integer>();
            List<Node> nextLevels = new ArrayList<Node>();
            for (Node node : levelNodes) {
                levelVals.add(node.val);
                nextLevels.addAll(node.children);
            }
            ans.add(levelVals);
            levelOrder(nextLevels, ans);
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
