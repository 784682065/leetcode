package com.example.leetcode.solution;

import javax.swing.tree.TreeNode;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-26 9:22
 */
public class Solution543 {


    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        treeNodelength(root);

        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int treeNodelength(TreeNode node) {

        if (node == null) return 0; // 访问到空节点了，返回0
        int L = treeNodelength(node.left); // 左儿子为根的子树的深度
        int R = treeNodelength(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度

    }

}


