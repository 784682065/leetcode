package com.example.leetcode.solution;

import java.util.*;

public class Solution133 {


    /**
     * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
     * 输出：[[2,4],[1,3],[2,4],[1,3]]
     * 解释：
     * 图中有 4 个节点。
     * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
     * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
     * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
     * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
     * <p>
     * 输入：adjList = [[]]
     * 输出：[[]]
     * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
     */
    public static void main(String[] args) {
        Solution133_Node node1 = new Solution133_Node(1);
//        Solution133_Node node2 = new Solution133_Node(2);
//        Solution133_Node node3 = new Solution133_Node(3);
//        Solution133_Node node4 = new Solution133_Node(4);
//        node1.neighbors = Arrays.asList(node2, node4);
//        node2.neighbors = Arrays.asList(node1, node3);
//        node3.neighbors = Arrays.asList(node2, node4);
//        node4.neighbors = Arrays.asList(node1, node3);
        Solution133_Node solution133_node = cloneGraph(node1);
        System.out.println(solution133_node);
    }

    private static HashMap<Solution133_Node, Solution133_Node> visited = new HashMap<>();

    public static Solution133_Node cloneGraph(Solution133_Node node) {
        if (node == null) {
            return null;
        }

        if (node.val == 0) {
            return new Solution133_Node();
        }

        return f(node);
    }

    public static Solution133_Node f(Solution133_Node node) {

        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Solution133_Node cloneNode = new Solution133_Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node, cloneNode);

        if (!node.neighbors.isEmpty()) {
            for (Solution133_Node n : node.neighbors) {
                cloneNode.neighbors.add(f(n));
//                else {
//                    return new Solution133_Node(n.val);
//                }
            }
        }
        return cloneNode;
    }
}
