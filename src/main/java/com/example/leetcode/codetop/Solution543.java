package com.example.leetcode.codetop;

public class Solution543 {

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


    private static int res ;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftWidth = 0, rightWidth = 0;
        if (root.left != null) {
            leftWidth = dfs(root.left) + 1;
        }
        if (root.right != null) {
            rightWidth = dfs(root.right) + 1;
        }

        res = Math.max(res, leftWidth + rightWidth);

        // 该节点最大的贡献
        return Math.max(leftWidth, rightWidth);
    }


    public static void main(String[] args) {

        TreeNode treeNode4  = new TreeNode(4);
        TreeNode treeNode5  = new TreeNode(5);
        TreeNode treeNode2  = new TreeNode(2,treeNode4,treeNode5);
        TreeNode treeNode3  = new TreeNode(3);
        TreeNode treeNode  = new TreeNode(1,treeNode2,treeNode3);

        Solution543 solution543 = new Solution543();
        System.out.println(solution543.diameterOfBinaryTree(treeNode));

    }
}
