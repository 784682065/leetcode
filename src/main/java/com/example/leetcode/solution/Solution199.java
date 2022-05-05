package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: hzp
 * @date: 2022/4/9
 * @description:
 */
public class Solution199 {

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


    // 层序遍历就好,把每层的最后一个数拿出来
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<TreeNode> tmp = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll.left != null) {
                tmp.add(poll.left);
            }
            if (poll.right != null) {
                tmp.add(poll.right);
            }

            if (queue.isEmpty()) {
                res.add(poll.val);
                queue.addAll(tmp);
                tmp.clear();
            }
        }
        return res;
    }

}
