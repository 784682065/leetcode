package com.example.leetcode.codetop;

public class Solution105 {

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

    /**
     *  分清前序和中序在干嘛
     * [  根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     */
    public TreeNode doBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        // preStart 为先序遍历头结点位置
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 头节点在中序遍历的位置
        int inorderRootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }

        // 左边剩余元素个数
        int leftNum = inorderRootIndex - inStart;
        root.left = doBuild(preorder, preStart + 1, preStart + leftNum, inorder, inStart, inorderRootIndex -1);

        // 找右边的头结点,在 先序遍历头结点位置 去除掉 中序遍历左边有的节点个数的位置
        root.right = doBuild(preorder, preStart + leftNum + 1, preEnd,  inorder, inorderRootIndex + 1, inEnd);


        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return this.doBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 10, 20, 15, 7};
        int[] inorder = {10, 9, 3, 15, 20, 7};
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
