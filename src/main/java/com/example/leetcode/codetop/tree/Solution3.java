package com.example.leetcode.codetop.tree;

import netscape.security.UserTarget;

import java.util.*;

/**
 * @author huzepeng
 * @date 2022/9/23
 */
public class Solution3 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root!= null || stack.isEmpty()){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }

            TreeNode pop = stack.pop();
            root = pop.left;
        }

        Collections.reverse(res);

        return res;
    }

    public List<Integer> postorderTraversalNormal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        //  正常版本
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        // 使用pre 来标记他的右节点遍历过没有
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }



}
