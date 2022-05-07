package com.example.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 10:57
 */
public class Solution105 {

    private Map<Integer, Integer> indexMap;

    /**
     * 主要步骤
     * 1. 通过前序数组拿出第一个 作为根节点
     * 2. 左子树是 中序遍历数组中 该根节点的左边元素; 前序遍历分出边界是: [自己位置加1 , 中序遍历该根节点左边元素个数加上自己初始位置]
     * 3. 右子树是 中序遍历数组中,该根节点右边元素; 前序遍历分出边界是:[中序遍历该根节点左边元素个数加上自己初始位置, 到前序最右边]
     * 4.
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素 , inorder_root - 1 为中序遍历该节点左子树的最右边界
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

}
