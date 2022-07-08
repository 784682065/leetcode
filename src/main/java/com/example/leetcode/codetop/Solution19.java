package com.example.leetcode.codetop;

public class Solution19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(-1,head);

        int length = 1;
        int slowpos = 1;
        ListNode slow = head, fast =head,pre = dump;
        while (true){
            if (fast.next == null){
                break;
            }
            if (fast.next.next == null){
                ++length;
                break;
            }
            pre = slow;
            slow=  slow.next;
            fast = fast.next.next;
            length += 2;
            slowpos ++;
        }
        int need = length - n +1;


        if (need >=  slowpos){
            int stillRun = need - slowpos;
            for (int i = 0; i < stillRun; i++) {
                pre = slow;
                slow=  slow.next;
            }
            pre.next = slow.next;
        }else {
            pre= dump;
            ListNode start = head;
            // 从头走
            for (int i = 1; i < need; i++) {
                pre = start;
                start = start.next;
            }
            pre.next = start.next;
        }

        return dump.next;
    }

//    public static void main(String[] args) {
//
//        ListNode listNode5 = new ListNode(5,null);
//        ListNode listNode4 = new ListNode(4,listNode5);
//        ListNode listNode3 = new ListNode(3,listNode4);
//        ListNode listNode2 = new ListNode(2,listNode3);
//        ListNode listNode1 = new ListNode(1,listNode2);
//
//        Solution19 solution19 = new Solution19();
//        ListNode listNode = solution19.removeNthFromEnd(listNode1,5);
//        System.out.println(listNode);
//    }
}
