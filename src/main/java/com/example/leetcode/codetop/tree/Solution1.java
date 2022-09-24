package com.example.leetcode.codetop.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序非递归
 */
public class Solution1 {


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

    public List<Integer> preorderTraversal(TreeNode root) {


        // 非递归
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            // 到这一步说明pop节点的左上片全都便利完了
            TreeNode pop = stack.pop();
            root = pop.right;
        }
        return res;
    }
}
