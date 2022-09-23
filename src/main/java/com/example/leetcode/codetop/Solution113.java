package com.example.leetcode.codetop;

import java.util.*;

public class Solution113 {

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

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, targetSum, path, root.val);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path, int sum) {

        if (root.left == null && root.right == null && sum == targetSum){
            res.add(new ArrayList<>(path));
        }


        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, targetSum, path, sum + root.left.val);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, targetSum, path, sum + root.right.val);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode10 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(11,treeNode10,treeNode9);
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(4,treeNode7,treeNode6);
        TreeNode treeNode4 = new TreeNode(4,treeNode8,null);
        TreeNode treeNode0 = new TreeNode(13);
        TreeNode treeNode00 = new TreeNode(8,treeNode0,treeNode5);
        TreeNode treeNode1 = new TreeNode(5,treeNode4,treeNode00);
        Solution113 solution113 = new Solution113();
        List<List<Integer>> lists = solution113.pathSum(treeNode1, 22);
        System.out.println(lists);
    }

}
