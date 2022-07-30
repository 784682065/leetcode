package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {

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

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root ==null){
            return null;
        }

        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root ==null){
            return ;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversalByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (null == root){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = stack.peek();
        while (!stack.isEmpty() ){
            TreeNode peek = stack.peek();
            if (peek.left !=null && peek.left!=cur && peek.right !=cur){
                stack.push(peek.left);
            } else if (peek.right !=null && peek.right !=cur) {
                stack.push(peek.right);
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,null);
        TreeNode treeNode = new TreeNode(1,null,treeNode2);

        Solution145 solution145 = new Solution145();
        List<Integer> list = solution145.postorderTraversalByStack(treeNode);
        System.out.println(list);
    }


}
