package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hzp
 * @date: 2022/4/7
 * @description:
 */
public class Solution94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        doTraveral(root, res);
        return res;
    }

    public void doTraveral(TreeNode root, List<Integer> res) {

        if (root == null)
            return;
        doTraveral(root.left, res);
        res.add(root.val);
        doTraveral(root.right, res);
    }

}
