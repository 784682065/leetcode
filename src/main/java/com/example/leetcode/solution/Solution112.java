package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-28 13:56
 */
public class Solution112 {


    /**
     * 正确做法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //呀左右子节点均为null 才算是叶子节点
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }


    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int now, int sum) {
        if (root == null) {
            return sum == now;
        }

        boolean dfs = dfs(root.left, now + root.val, sum);
        boolean dfs1 = dfs(root.right, now + root.val, sum);

        return dfs || dfs1;
    }


}
