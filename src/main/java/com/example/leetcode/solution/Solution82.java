package com.example.leetcode.solution;

import java.util.*;

/*
 * @author: hzp
 * @date: 2022/4/9
 * @description:
 */
public class Solution82 {

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

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return head;

        ListNode dump = new ListNode(-101);
        dump.next = head;
        ListNode pre=dump,cur =head;
        int curVal = head.val,count = 0;


        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val == curVal) {
                // 重复标志+1
                count++;
            } else {
                // 如果是正常的话
                if (count == 0) {
                    // pre正常转移
                    pre = cur;
                } else {
                    //不正常进行断链操作
                    pre.next = next;
                    count = 0;
                }
            }
            curVal = next.val;
            cur = next;
        }

        if (count > 0){
            pre.next = null;
        }

        return dump.next;
    }


    public ListNode officialDeleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }




    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();

//        ListNode listNode6 = new ListNode(5);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode5 = new ListNode(4,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(3,listNode3);
        ListNode listNode1 = new ListNode(2,listNode2);
        ListNode listNode = new ListNode(1,listNode1);


        ListNode listNode7 = solution82.officialDeleteDuplicates(listNode);
        System.out.println(listNode7);


    }
}
