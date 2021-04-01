package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-29 9:17
 */
public class Solution129 {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);

        return res;  //因为到达一个叶子节点之后, 左右节点都为空会加两次,所以结果是2倍
    }

    private void dfs(TreeNode root, int sum) {

        int val = root.val;
        //若是叶子节点就加
        if (root.right == null && root.left == null) {
            res += sum * 10 + val;
            return;
        }

        if (root.left != null)
            dfs(root.left, sum * 10 + val);

        if (root.right != null)
            dfs(root.right, sum * 10 + val);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        Solution129 solution129 = new Solution129();
        int i = solution129.sumNumbers(treeNode);
        System.out.println(i);
    }

}
