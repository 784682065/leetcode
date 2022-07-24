package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/5/18
 * @description:
 */
public class Solution226 {

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }



    public static void main(String[] args) {

        TreeNode node9 = new TreeNode(9);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);
        TreeNode node4 = new TreeNode(4, node2, node7);

        Solution226 solution226 = new Solution226();
        TreeNode node = solution226.invertTree(node4);

        System.out.println(node);

    }


}
