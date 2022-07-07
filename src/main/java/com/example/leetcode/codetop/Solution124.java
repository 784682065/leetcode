package com.example.leetcode.codetop;

public class Solution124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        cal(root);
        return res;
    }


    public int cal(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        int left = Math.max(cal(treeNode.left),0);
        int right = Math.max(cal(treeNode.right),0);

        int curSum  = left +  treeNode.val + right;

        res = Math.max(curSum,res);

        return   treeNode.val + Math.max(left,right);
    }


}
