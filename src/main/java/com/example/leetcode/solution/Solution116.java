package com.example.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-29 8:38
 */
public class Solution116 {


    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        //层序遍历 连接
        Queue<Node> queue = new LinkedList<>();
        //初始化队列
        queue.add(root);

        while (!queue.isEmpty()) {

            //size 定义在 for循环外面
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i < size - 1) {
                    //只是拿到队列头元素,而不删除
                    node.next = queue.peek();

                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }


        }
        return root;
    }
}
