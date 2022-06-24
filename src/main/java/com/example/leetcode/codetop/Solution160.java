package com.example.leetcode.codetop;

import java.util.HashSet;

public class Solution160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode dumpA =headA;
        ListNode dumpB =headB;
        while (dumpA !=null  || dumpB != null){

            if (dumpA!=null){
                if (set.contains(dumpA)){
                    return dumpA;
                }else {
                    set.add(dumpA);
                }
                dumpA = dumpA.next;
            }

            if (dumpB!=null){
                if (set.contains(dumpB)){
                    return dumpB;
                }else {
                    set.add(dumpB);
                }
                dumpB = dumpB.next;
            }
        }

        return null;
    }


    /**
     * 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。
     * 如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。
     * 若相交，链表A： a+c, 链表B : b+c. a+c+b    +c = b+c+a   +c 。则会在公共处c起点相遇。
     * 若不相交，a +b = b+a 。因此相遇处是NULL
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }



}
