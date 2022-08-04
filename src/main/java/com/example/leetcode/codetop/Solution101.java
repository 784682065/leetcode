package com.example.leetcode.codetop;

public class Solution101 {
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

    public boolean isSymmetric(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right ==null){
            return true;
        }
        if ((left == null) || ( right ==null )  || left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(2,treeNode,treeNode2);
        TreeNode treeNode5 = new TreeNode(2,treeNode3,treeNode1);
        TreeNode root = new TreeNode(1,treeNode4,treeNode5);
        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(root));
    }


}
