package com.example.leetcode.solution;

import java.util.HashMap;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 10:57
 */
public class Solution105 {

    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();


    /**
     * 大概算法就是三部
     * <p>
     * 1. 根据前序当前的根, 拿出 中序数组该值所在的索引值
     * <p>
     * 2. 根植 创建node
     * <p>
     * 3. root.left = 递归调用  F(最开始的左边值,到索引值)
     *    root.right =  递归调用  F(索引值+1,右边边界值)
     */
    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left == in_right)
            return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx];  //开始拿出最前面的节点值
        TreeNode root = new TreeNode(root_val);




        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val); //拿出中序遍历数组的节点值的索引

        // recursion
        pre_idx++;   //每次前序遍历数组取完一个值 后根节点往后走
        // build left subtree
        root.left = helper(in_left, index); //处理左边的, 将返回的值添加至root.left
        // build right subtree
        root.right = helper(index + 1, in_right); //处理右边的
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);  //value 和数组索引位置
        return helper(0, inorder.length);
    }

}
