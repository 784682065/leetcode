package com.example.leetcode.solution;

import java.util.Stack;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 9:04
 */
public class Solution100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(1);

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }


    //错误原因不能用中序遍历确定唯一一棵树  1,1  与 1,null,1  两个结果都是01010
    public static boolean isSameTree1(TreeNode p, TreeNode q) {

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        midOrder(p, stackA);
        midOrder(q, stackB);

        while (!stackA.empty() && !stackB.empty()) {

            if (!(stackA.pop() == stackB.pop())) {
                return false;
            }
        }

        if (!stackA.empty() || !stackB.empty()) {
            return false;
        }


        return true;
    }

    //树的中序遍历 ,值写入数组,空值写0
    static void midOrder(TreeNode treeNode, Stack<Integer> stack) {
        if (treeNode == null) {
            stack.push(0);
            return;
        }

        midOrder(treeNode.left, stack);
        stack.push(treeNode.val);
        midOrder(treeNode.right, stack);

        return;
    }

}
