package com.example.leetcode.codetop;

import java.util.*;

public class JSolution36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Node> map = new HashMap<>();

        dfs(root,list,map);

        list.sort(Comparator.comparingInt(a -> a));

        // 首位节点单独处理
        Integer num = list.get(0);
        Node head = map.get(num);
        // left 指向前驱.
        head.left = map.get(list.get(list.size()-1));
        map.get(list.get(list.size()-1)).right = head ;
        Node pre =head;
        for (int i = 1; i < list.size(); i++) {
            Integer numb = list.get(i);
            Node node = map.get(numb);
            pre.right = node;
            node.left = pre;
            pre = node;
        }

        return head;
    }

    private void dfs(Node root, List<Integer> list, Map<Integer, Node> map) {
        if (root == null){
            return;
        }

        list.add(root.val);
        map.put(root.val,root);
        dfs(root.left,list,map);
        dfs(root.right,list,map);
    }


    public static void main(String[] args) {



    }
}
