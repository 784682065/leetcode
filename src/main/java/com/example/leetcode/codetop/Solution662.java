package com.example.leetcode.codetop;

import javafx.util.Pair;

import java.util.*;

public class Solution662 {

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

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<Pair<TreeNode, Integer>>();


        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueIdx = new LinkedList<>();
        queue.offer(root);
        queueIdx.offer(1);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int start = queueIdx.peek();
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                Integer idx = queueIdx.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    queueIdx.offer(2 * idx);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    queueIdx.offer(2 * idx + 1);
                }
                if (i == size - 1) {
                    end = idx;
                }
            }
            ans = Math.max(end - start +1, ans);
        }
        return ans;
    }

}
