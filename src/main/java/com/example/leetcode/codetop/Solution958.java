package com.example.leetcode.codetop;

import java.util.*;

public class Solution958 {

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

    public boolean isCompleteTreeMy(TreeNode root) {

        // 左右差值大于1 不是完成的, 此外有右边节点,没有左节点也是不行的
        if (root == null) {
            return true;
        }
        Queue<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        // 当前层数
        boolean findNull = false;
        while (!treeNodeDeque.isEmpty()) {
            int size = treeNodeDeque.size();
            for (int i = 0; i < size; i++) {

                TreeNode poll = treeNodeDeque.poll();

                if (poll == null) {
                    findNull = true;
                }else {
                    // 如果之前找到过空值,但是后面还有值的话就是不完全二叉树
                    if (findNull)
                        return false;
                    treeNodeDeque.add(poll.left);
                    treeNodeDeque.add(poll.right);
                }
            }
        }
        return true;
    }

    class ANode {  // Annotated Node
        TreeNode node;
        int code;

        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    /**
     * 中间有null,后面还有值的话,node的编号就会大于node中数组数量
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i - 1).code == nodes.size();
    }

    public static void main(String[] args) {

        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(2, treeNode5, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode7, treeNode8);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode2);
        Solution958 solution958 = new Solution958();
        System.out.println(solution958.isCompleteTree(treeNode1));


    }

}
