package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-28 14:21
 */
public class Solution113 {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) return res;

        List<Integer> list = new ArrayList<>();
        dfs(root, list, sum);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> list, int sum) {
        if (root == null) return;

        list.add(root.val);
        sum -= root.val;

        //为子节点 且 sum 值为空
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));

            /**
             * 注意：这里 return 之前必须重置
             */
            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, list, sum);
        dfs(root.right, list, sum);

        /**
         * 回溯的第二个点
         */
        list.remove(list.size() - 1);
    }
}
