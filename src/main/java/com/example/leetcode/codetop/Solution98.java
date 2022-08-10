package com.example.leetcode.codetop;

public class Solution98 {
    public static class TreeNode {
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

    public boolean isValidBST(TreeNode root) {

        return doValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid(TreeNode root, long minValue, long maxValue) {

        if (root == null){
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue ){
            return false;
        }
        return doValid(root.left , minValue , root.val)   &&  doValid(root.right , root.val , maxValue)  ;
    }

    public static void main(String[] args) {
        TreeNode treeNode1  = new TreeNode(1);
//        TreeNode treeNode3  = new TreeNode(3);
        TreeNode treeNode  = new TreeNode(1,treeNode1,null);

        Solution98 solution98 = new Solution98();
        System.out.println(solution98.isValidBST(treeNode));


    }
}
