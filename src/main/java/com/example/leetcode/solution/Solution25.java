package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/3/21
 * @description:
 */
public class Solution25 {

    static class ListNode {
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

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1 || null == head.next)
            return head;

        // 从第一个开始算起, 改变头尾指针
        ListNode h = new ListNode(-1, head);
        ListNode ppre = h;
        ListNode pre = h.next;

        boolean flag = true;
        while (flag) {

            ListNode temp = pre;
            if (null == temp)
                break;

            for (int i = 1; i < k; i++) {
                temp = temp.next;
                if (null == temp) {
                    flag = false;
                    break;
                }
            }


            if (flag) {
                ListNode start = pre;
                for (int i = 1; i < k; i++) {
                    ListNode next = pre.next;
                    swap(pre, start, next, ppre);
                    start = next;
                }
                ppre = pre;
                pre = pre.next;
            }
        }

        return h.next;
    }

    private void swap(ListNode end, ListNode start, ListNode next, ListNode ppre) {
        ListNode node = next.next;
        next.next = start;
        end.next = node;
        ppre.next = next;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);


        Solution25 solution25 = new Solution25();
        ListNode listNode = solution25.myR(listNode1, listNode5);
        listNode1.next = listNode6;

        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    private ListNode myR(ListNode head, ListNode tail) {
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode prev = tail.next;
        ListNode  h = head;

        while ( prev != tail){
            ListNode next = h.next;
            h.next = prev;
            prev = h;
            h = next;
        }

        prev.next = tail.next;
        return prev;
    }


    public ListNode offical_ReverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = tail;
            tail = head;
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }


}
