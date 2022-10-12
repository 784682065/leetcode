package com.example.leetcode.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: huzepeng
 * @date: 2022/9/25
 * @desc:
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> res;

    //先序遍历
    public List<Integer> pre(int[] mid, int[] after) {
        res = new ArrayList<>();
        TreeNode root = buildTree(mid, after);
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


    /**
     * 中序分割左右子树,后序拿到根节点
     *
     * @param mid
     * @param after
     * @return
     */
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] mid, int[] after) {
        // map 存放树val,索引值
        map = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            // val-index
            map.put(mid[i], i);
        }
        return doBuild(mid, 0, mid.length - 1, after, 0, after.length - 1);
    }

    private TreeNode doBuild(int[] mid, int mleft, int mright, int[] after, int aleft, int aright) {
        if (mleft > mright)
            return null;
        // 根节点的值
        int root = after[aright];
        TreeNode treeNode = new TreeNode(root);
        // 用根节点值分割中序
        Integer midIndex = map.get(root);
        // 左边剩下的值
        int left = midIndex - mleft;

        treeNode.left = doBuild(mid, mleft, mleft + left - 1, after, aleft, aleft + left - 1);
        treeNode.right = doBuild(mid, midIndex + 1, mright, after, aleft + left , aright - 1);

        return treeNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] mid = {9, 3, 15, 20, 7};
        int[] after = {9, 15, 7, 20, 3};

//        solution.pre(mid, after);
        System.out.println(solution.pre(mid, after));

    }

}
