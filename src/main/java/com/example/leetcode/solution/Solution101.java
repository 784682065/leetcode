package com.example.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 9:40
 */
public class Solution101 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);

        boolean symmetric1 = isSymmetric1(treeNode);
        System.out.println(symmetric1);

    }


    public static boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll(); //拿出头结点 并且remove
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && check(p.right, q.left) && check(q.right, p.left);
    }

}
