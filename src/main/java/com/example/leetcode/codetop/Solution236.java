package com.example.leetcode.codetop;

import java.util.LinkedList;
import java.util.Queue;

public class Solution236 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = root;
        travel(root, p, q);
        return lca;
    }

    private Boolean travel(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }

        Boolean travelLeft = travel(root.left, p, q);
        Boolean travelRight = travel(root.right, p, q);

        if ((travelLeft && travelRight) || ((root == p || root == q) && (travelLeft || travelRight))) {
            lca = root;
        }

        return (root == p || root == q) || travelLeft || travelRight;
    }
}


