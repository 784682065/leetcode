package com.example.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-05-06 15:38
 */
public class Solution114 {

    public static void main(String[] args) {
        Solution114 solution114 = new Solution114();

        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(-4);

        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;

        solution114.hasCycle(head);

    }

    public boolean hasCycleDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}