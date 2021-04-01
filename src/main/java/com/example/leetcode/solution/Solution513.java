package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-28 9:38
 */
public class Solution513 {


    int res = 0;
    int count = 0;

    public int findBottomLeftValue(TreeNode root) {

        res = root.val;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, Integer count) {

        if (root == null) {
            return;
        }
        if (count > this.count) {
            this.count = count;
            res = root.val;
        }
        dfs(root.left,count+1);
        dfs(root.right,count+1);
    }
}
