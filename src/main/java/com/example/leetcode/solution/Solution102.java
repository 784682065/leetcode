package com.example.leetcode.solution;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: hzp
 * @date: 2022/3/17
 * @description:
 */
public class Solution102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> htn = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = q.poll();

                htn.add(tn.val);
                if (null!= tn.left)
                    q.add(tn.left);
                if (null!= tn.right)
                    q.add(tn.right);

            }
            if (!htn.isEmpty()) {
                res.add(htn);
            }
        }
        return res;
    }
}
