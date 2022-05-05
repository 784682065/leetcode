package com.example.leetcode.solution;

import java.util.List;

/**
 * @author: hzp
 * @date: 2022/4/28
 * @description:
 */
public class Solution148 {

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


    public ListNode sortList_timeLimit(ListNode head) {

        ListNode dump = new ListNode(-1);

        while (head != null) {

            if (dump.next == null) {
                dump.next = new ListNode(head.val);
                head = head.next;
                continue;
            }
            // 不然的话就遍历dump
            ListNode pre = dump;
            ListNode dumpnode = dump.next;
            boolean sign = false;
            while (dumpnode != null) {
                if (dumpnode.val >= head.val) {
                    pre.next = new ListNode(head.val, pre.next);
                    sign = true;
                    break;
                } else {
                    pre = dumpnode;
                    dumpnode = dumpnode.next;
                }
            }

            if (!sign) {
                pre.next = new ListNode(head.val, pre.next);
            }

            head = head.next;
        }


        return dump.next;
    }


    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

//    1. 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 22 步，慢指针每次移动 11 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
//
//    2. 对两个子链表分别排序。
//
//    3. 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并
    //时间复杂度是 O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)),最适合链表的是归并排序
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(1,listNode1);
        ListNode listNode3 = new ListNode(2,listNode2);
        ListNode listNode4 = new ListNode(4,listNode3);

        Solution148 solution148 = new Solution148();
        ListNode listNode = solution148.sortList(listNode4);
        System.out.println(listNode);

    }
}
