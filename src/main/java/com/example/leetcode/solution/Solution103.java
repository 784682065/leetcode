package com.example.leetcode.solution;

import com.sun.deploy.util.ArrayUtil;
import com.sun.jmx.remote.internal.ArrayQueue;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;


public class Solution103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                // 双端队列逆序的话每次放第一个就好, 默认的add是每次放最后!!!!!!!
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution103.TreeNode treeNode = new TreeNode(7);
        Solution103.TreeNode treeNode1 = new TreeNode(15);
        Solution103.TreeNode treeNode2 = new TreeNode(20);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode;

        Solution103.TreeNode treeNode3 = new TreeNode(9);
        Solution103.TreeNode treeNode4 = new TreeNode(3);
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode2;

        Solution103 solution103 = new Solution103();
        solution103.zigzagLevelOrder(treeNode4);

    }

}
