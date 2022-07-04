package com.example.leetcode.codetop;

import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;

public class Solution92 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right)
            return head;

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump, cur = head, next, end = null , tmp = null;

        int index = 1;
        while (index < right) {

            if (index == left) {
//                开始换, pre 不会变, cur 会变, end 不会变
                end = cur;
            }

            if (index >= left){
                next =  end.next;
                pre.next = next;
                tmp = next.next;
                next.next = cur;
                end.next = tmp;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }

            index++;
        }

        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode5  = new ListNode(5,null);
//        ListNode listNode4  = new ListNode(4,listNode5);
        ListNode listNode3  = new ListNode(3,listNode5);
//        ListNode listNode2  = new ListNode(2,listNode3);
//        ListNode listNode1  = new ListNode(1,listNode2);

        Solution92 solution92 = new Solution92();
        ListNode listNode = solution92.reverseBetween(listNode3, 1, 2);
        System.out.println(listNode);
    }
}
