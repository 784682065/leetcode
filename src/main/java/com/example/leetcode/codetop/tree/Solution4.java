package com.example.leetcode.codetop.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huzepeng
 * @date: 2022/9/23
 * @desc: 前中序还原树
 */
public class Solution4 {

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

    // 值和索引位置
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return doBuildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {

        if (pleft > pright)
            return null;

        // 头节点值
        int i = preorder[pleft];
        // 头节点值去中序遍历里分左右
        // 中序的index 值
        Integer index = map.get(i);
//        左边有的树木
        int leftnum = index - ileft;
        // 头结点
        TreeNode treeNode = new TreeNode(i);
        treeNode.left = doBuildTree(preorder, pleft+1, pleft+leftnum, inorder, ileft, index - 1);
        treeNode.right = doBuildTree(preorder, pleft+leftnum + 1, pright, inorder, index + 1, iright);

        return treeNode;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution4 solution4 = new Solution4();
        TreeNode treeNode = solution4.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
