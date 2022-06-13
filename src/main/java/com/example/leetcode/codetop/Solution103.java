package com.example.leetcode.codetop;

import java.util.*;

public class Solution103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            Deque<Integer> h = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();

                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                if (isOrderLeft) {
                    h.offerLast(t.val);
                } else {
                    h.offerFirst(t.val);
                }

            }
            res.add(new LinkedList<>(h));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }

}
