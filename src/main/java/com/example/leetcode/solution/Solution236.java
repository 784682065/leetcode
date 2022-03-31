package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/3/29
 * @description:
 */

public class Solution236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode ans;

    public Solution236() {
        this.ans = null;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val == p.val || root.val == q.val) {
            return root;
        }


        fun(root, p, q);
        return this.ans;
    }

    private boolean fun(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean left, right, sign = false;
        if (root.val == q.val || root.val == p.val) {
            sign = true;
        }

        left = fun(root.left, p, q);
        right = fun(root.right, p, q);
        if ((left && right) || (sign && (left || right))) {
            this.ans = root;
        }

        return left || right || sign;
    }
}
