package com.example.leetcode.codetop;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution104 {

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

    public int maxDepth(TreeNode root) {

        if (root ==null)
            return 0;

        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            ++ res;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }

        }
        return res;
    }

}
