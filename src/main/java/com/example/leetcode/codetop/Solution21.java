package com.example.leetcode.codetop;

/**
 * @author: hzp
 * @date: 2022/5/30
 * @description:
 */
public class Solution21 {

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


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dump = new ListNode(-1);
        ListNode ptr1 = list1, ptr2 = list2, ptr0 = dump;
        while (ptr1 != null && ptr2 != null) {

            if (ptr1.val < ptr2.val) {
                ptr0.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                ptr0.next = ptr2;
                ptr2 = ptr2.next;
            }
            ptr0 = ptr0.next;
        }

        ptr0.next = (ptr1 == null) ? ptr2 : ptr1;


        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode3  = new ListNode(4 );
        ListNode listNode2  = new ListNode(2 , listNode3);
        ListNode listNode1  = new ListNode(1, listNode2);


        ListNode listNode4  = new ListNode(4);
        ListNode listNode5  = new ListNode(3,listNode4);
        ListNode listNode6  = new ListNode(1,listNode5);

        Solution21 solution21 = new Solution21();
        ListNode listNode = solution21.mergeTwoLists(listNode1, listNode6);
        System.out.println(listNode);

    }
}
