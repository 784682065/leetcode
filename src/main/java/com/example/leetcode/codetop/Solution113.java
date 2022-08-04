package com.example.leetcode.codetop;

import java.util.*;

public class Solution113 {

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

}
