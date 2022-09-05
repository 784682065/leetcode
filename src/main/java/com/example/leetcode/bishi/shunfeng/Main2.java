package com.example.leetcode.bishi.shunfeng;

import java.util.*;

public class Main2 {

    public static class TreeNode {
        int number;
        int val;
        List<TreeNode> son;

        public TreeNode(int number, int val, List<TreeNode> son) {
            this.number = number;
            this.val = val;
            this.son = son;
        }
        public void addNode(TreeNode treeNode) {
            son.add(treeNode);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] treep = new int[n + 1];
        int[] treev = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            treep[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            treev[i] = scanner.nextInt();
        }
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(1, treev[1], new ArrayList<>());
        map.put(1, root);
        for (int i = 2; i <= n; i++) {
            TreeNode treeNode = map.get(treep[i]);
            treeNode.addNode(new TreeNode(i, treev[i], new ArrayList<>()));
        }
        dfs(root);
        System.out.println(res);
    }

    static int res = 0;
    private static int dfs(TreeNode root) {
        if (root.son.isEmpty()) {
            return 1;
        }
        int sum =0;
        for (TreeNode treeNode : root.son) {
            int dfs = dfs(treeNode);
            if (root.val != treeNode.val) {
                dfs = dfs+1;
            }
            sum += dfs;
        }
        return sum;
    }
}
