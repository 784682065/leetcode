package com.example.leetcode.codetop;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 看题解 https://leetcode.cn/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
        // 其实不用list+ map ,只需要一个map 类型为<Node,Node> 第一个放原先的Node,第二个放新的Node.
        LinkedList<Integer> list  = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        Node cur = head;
        // 记录每一个节点的位置
        int pos = 0;
        while (cur !=null){
            Node random = cur.random;
            map.put(pos,new Node(cur.val));
            ++pos;
            if (random == null){
                list.add(null);
                cur = cur.next;
                continue;
            }
            Node temp = head;
            int i =0;
            while (temp != random) {
                i++;
                temp = temp.next;
            }
            list.add(i);
            cur = cur.next;
        }

        Node dump = new Node(-1);
        Node temp = dump;
        for (int i = 0; i < pos; i++) {
            temp.next = map.get(i);
            temp.next.random = map.get(list.get(i));
            temp = temp.next;
        }

        return dump.next;
    }

    public static void main(String[] args) {
        Node node1= new Node(3);
        Node node2= new Node(3);
        Node node3= new Node(3);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = null;
        node3.random =null;
        Solution138 solution138 = new Solution138();
        solution138.copyRandomList(node1);

    }
}
