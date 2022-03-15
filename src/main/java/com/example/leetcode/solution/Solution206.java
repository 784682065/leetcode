package com.example.leetcode.solution;


import java.util.ArrayList;

/**
 * @author: hzp
 * @date: 2022/3/15
 * @description:
 */
public class Solution206 {

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


//    public ListNode reverseList(ListNode head) {
//
//        ListNode ln = head;
//
//        if (head == null)
//            return head;
//
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        do{
//            arr.add(head.val);
//            head = head.next;
//        }while (head !=null);
//
//        int i = arr.size() -1;
//        head = ln;
//        while(head!=null){
//            head.val = arr.get(i);
//            head = head.next;
//            i--;
//        }
//
//        return ln;
//    }

    public ListNode reverseList(ListNode head) {
         ListNode prev = null;
         ListNode curr = head;
         while(curr !=null){
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }


         return prev;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ListNode listNode4 = solution206.reverseList(listNode);
        System.out.println(listNode4);
    }

}
