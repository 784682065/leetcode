package com.example.leetcode.codetop;

public class Solution110 {
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



    boolean res =  true;
    public int dfs(TreeNode root){

        if (root == null){
            return  0;
        }
        int leftHight = dfs(root.left) +1;
        int rightHight = dfs(root.right) +1;
        int abs = Math.abs(leftHight - rightHight);
        if (res && abs > 1){
            res =false;
        }
        return Math.max(rightHight, leftHight);

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        dfs( root);
        return res;
    }

}
