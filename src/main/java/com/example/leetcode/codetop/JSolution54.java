package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JSolution54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        dfs(root.right, list);
        list.add(root.val);
        dfs(root.left, list);
    }
}
