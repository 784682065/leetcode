package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/4/8
 * @description:
 */
public class Solution124 {

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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 要分清楚,该节点最大贡献度和 该节点的最大路径和, 这是两个变量
     * 这题没做出来的原因:
     * 1. 少分析了一个当前节点最大贡献度这个值,导致需要很多判断即时去报错,逻辑混乱.
     * 2. node == null该交给下一层递归去判断
     * @param node 节点
     * @return 该节点最大贡献度
     */
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 如果以当前节点为重点的话,计算该节点的最大路径和
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案, 都是某个节点的最大路径和做比较的
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值,供给其他节点计算
        return node.val + Math.max(leftGain, rightGain);
    }


}
