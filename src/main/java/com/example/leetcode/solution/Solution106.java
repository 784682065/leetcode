package com.example.leetcode.solution;

import java.util.HashMap;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 11:15
 */
public class Solution106 {

    /**
     * 这类问题在 Facebook 的面试中常常出现，它可以在 \mathcal{O}(N)O(N) 的时间内解决：
     * 通常从先序序列或者后序序列开始，根据不同遍历方法的规律，选择合适的节点构造树。
     * 例如：先序序列的 第一个 节点是根节点，然后是它的左孩子，右孩子等等。
     * 后序序列的 最后一个 节点是根节点，然后是它的右孩子，左孩子等等。
     * 从先序/后序序列中找到根节点，根据根节点将中序序列分为左子树和右子树。
     * 从中序序列中获得的信息是：如果当前子树为空（返回 None），否则继续构造子树。
     */
    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        int[] io = {9, 3, 15, 20, 7};
        int[] po = {9, 15, 7, 20, 3};
        TreeNode treeNode = solution106.buildTree(io, po);

    }


    int postIndex;
    int[] inorder; // 中序数组
    int[] postorder; //后序数组

    HashMap<Integer, Integer> idx = new HashMap<>(); //记录中序遍历值与索引值

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;
        postIndex = postorder.length - 1;
        int index = 0;
        for (Integer x : inorder) {
            idx.put(x, index++);
        }

        return helper(0, postorder.length);
    }

    private TreeNode helper(int left, int right) {

        if (left == right)
            return null;

        int val = postorder[postIndex];
        postIndex--;
        Integer inIndex = idx.get(val); //中序遍历位置
        TreeNode root = new TreeNode(val);

        root.right = helper(inIndex + 1, right);
        root.left = helper(left, inIndex);


        return root;
    }
}
