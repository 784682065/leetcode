package com.example.leetcode.solution;

import java.util.List;

/**
 * @author: hzp
 * @date: 2022/5/13
 * @description:
 */
public class Solution98 {

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

    /**
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean helper(TreeNode root, long lower, long upper) {

        if (root == null) {
            return true;
        }
        boolean left = true, right = true;

        if ( !(root.val > lower && root.val < upper)) {
            return false;
        }

        // 如果是右子树的话 , 根节点就是下限值
        if (root.right != null) {
            right = helper(root.right, root.val, upper);
        }

        if (root.left != null) {
            left = helper(root.left, lower, root.val);
        }


        //如果是左子树的话根节点就是上限值


        return right && left;
    }

    public static void main(String[] args) {
        TreeNode treeroot1  = new TreeNode(1);
        TreeNode treeroot3 = new TreeNode(3);
        TreeNode treeroot2  = new TreeNode(2, treeroot1,treeroot3);

        Solution98 solution98 = new Solution98();

        boolean validBST = solution98.isValidBST(treeroot2);
        System.out.println(validBST);

    }


}
