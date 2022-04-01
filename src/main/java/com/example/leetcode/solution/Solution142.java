package com.example.leetcode.solution;

import java.util.HashMap;

/**
 * @author: hzp
 * @date: 2022/4/1
 * @description:
 */
public class Solution142 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycleHash(ListNode head) {

        HashMap<ListNode, Integer> res = new HashMap<>();
        int i = -1;
        // 找到第一个null肯定是没有的
        while (null != head) {
            if (null == res.get(head)) {
                res.put(head, ++i);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {

       ListNode slow= head,fast = head;

       while (null != fast){
           slow = slow.next;
           if (fast.next !=null){
               fast = fast.next.next;
           }else {
               return null;
           }

           if (slow == fast){
               ListNode ptr = head;
               while (ptr != slow) {
                   ptr = ptr.next;
                   slow = slow.next;
               }
               return ptr;
           }
       }
       return null;
    }

    public static void main(String[] args) {
        Solution142 solution142 = new Solution142();
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;

        ListNode listNode4 = solution142.detectCycle(listNode);
        System.out.println(listNode4);

    }

}
