package com.example.leetcode.codetop;

/**
 * @author: huzepeng
 * @date: 2022/10/11
 * @desc:
 */
public class Solution61 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    /**
     * 时间差距基本在算了一次length
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;

        ListNode ptr2 = head;
        ListNode ptr1 = head;
        // 指针一先走k 步,走到头的话就从头走
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        k = k % length;
        //让快指针指向该去的地方
        while (k > 0) {
            if (ptr1.next != null)
                ptr1 = ptr1.next;
            else
                ptr1 = head;
            k--;
        }

        while (ptr1.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if (ptr1 == ptr2) {
            return head;
        }
        // 作为头
        ListNode newhead = ptr2.next;
        ptr2.next = null;
        ptr1.next = head;
        return newhead;
    }


    public ListNode rotateRightOFFICIAL(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        //设置快慢指针
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        ListNode cur = head;
        //统计链表长度取余
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        k = k % length;
        //让快指针指向该去的地方
        while (k > 0) {
            k--;
            if (fast.next == null)
                fast = head;
            else
                fast = fast.next;
        }
        //一起前进
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == slow)
            return head;
        //找出头节点
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }


    public static void main(String[] args) {

    }
}
