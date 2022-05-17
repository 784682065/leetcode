package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: hzp
 * @date: 2022/5/16
 * @description:
 */
public class Solution234 {


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

    public boolean isPalindrome(ListNode head) {

        // 回文是对称的, 把整个链表的值放在一个双向队列里

        // 到了一半一个头部出值一个尾部出值
        ListNode node = head;
        int len = 0;

        // LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
        Deque<Integer> deque = new LinkedList<>();

        while (node != null) {
            ++len;
            deque.add(node.val);
            node = node.next;
        }
        if (len == 1) {
            return true;
        }

        // 偶数则验证.
        while (!deque.isEmpty() && deque.size() != 1) {
            if (!deque.pollFirst().equals(deque.pollLast()))
                return false;
        }
        return true;
    }

    /**
     * 放到数组即可,比较省空间和时间
     * @param head
     * @return
     */
    public boolean isPalindrome_1(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    /**
     * 快慢指针最省空间 o(1)
     * @param head
     * @return
     */
    public boolean isPalindrome_2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        // 快慢指针找中间节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // 翻转后半部分
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(1);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        Solution234 solution234 = new Solution234();
        boolean palindrome = solution234.isPalindrome(listNode1);
        System.out.println(palindrome);

    }


}
