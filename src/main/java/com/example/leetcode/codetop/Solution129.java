package com.example.leetcode.codetop;

import java.util.Stack;

public class Solution129 {

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

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null){
            return sum;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){

            int size = stack.size();

            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();

                if (pop.left != null){
                    pop.left.val = pop.val *10 + pop.left.val;
                    stack.push(pop.left);
                }
                if (pop.right !=null){
                    pop.right.val = pop.val *10 + pop.right.val;
                    stack.push(pop.right);
                }

                if (pop.right == null && pop.left == null){
                    sum += pop.val;
                }
            }
        }
        return sum;
    }
}
