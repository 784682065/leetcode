package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: hzp
 * @date: 2022/5/5
 * @description:
 */
public class Solution144 {

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

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node !=null){
            while (node !=null){
//                LinkedList<>() push 是放到队列头, 而add 是加入队列尾
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return res;
    }

    public List<Integer> preorderTraversalM(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            // 当前节点左节点
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) { // 这里有个判断p2.right 不能是p1 自己
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1; //用这个p2的right 记录最开始的p1节点, 链接了之后会发生当前节点的 中序前驱节点的右子节点就是自己 .
                    p1 = p1.left;
                    continue;
                } else {   // && p2.right != p1 加上 p2.right != null 就说该前驱节点的右子节点是当前节点
                    p2.right = null; //如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。
                }
            } else {
                res.add(p1.val); // 如果当前的左节点为空, 则将当前节点加入答案
            }
            p1 = p1.right; //遍历当前节点的右节点
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode(2,null,treeNode4);
        TreeNode treeNode3 = new TreeNode(3,treeNode5,treeNode6);

        TreeNode root = new TreeNode(1,treeNode2,treeNode3);

        Solution144 solution144  = new Solution144();
        solution144.preorderTraversal(root);


    }


}
