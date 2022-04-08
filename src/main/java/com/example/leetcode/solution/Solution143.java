package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: hzp
 * @date: 2022/4/8
 * @description:
 */
public class Solution143 {

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

    /**
     * L0 → L1 → … → Ln - 1 → Ln
     * 转变为
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     *
     * @param head 头部
     */
    public void reorderList(ListNode head) {

        Stack<ListNode> listNodeStack = new Stack<>();

        // 认为造一个头部节点
        ListNode dump = new ListNode(-1);
        dump.next = head;

        int count = 0;
        while (head != null) {
            listNodeStack.push(head);
            count++;
            head = head.next;
        }

        // 拿出这么多
        int mid = count / 2;
        head = dump.next;
        ListNode next;

        for (int i = 0; i < mid; i++) {
            //拿出 Ln, Ln-1,... Ln-(count/2)+1
            ListNode pop = listNodeStack.pop();
            next = head.next;
            head.next = pop;
            pop.next = next;
            head = next;
        }

        //最后一个节点断链
        head.next = null;
        head = dump.next;
    }

    public void reorderListByArrayList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(5);
        ListNode listNode0 = new ListNode(4, listNode);
        ListNode listNode1 = new ListNode(3, listNode0);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);

        Solution143 solution143 = new Solution143();
        solution143.reorderList(listNode3);
    }


    public void OfficalReorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
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

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }


}
