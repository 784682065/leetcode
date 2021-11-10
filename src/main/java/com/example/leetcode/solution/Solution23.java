package com.example.leetcode.solution;

import java.util.*;

/**
 * @author: hzp
 * @date: 2021/10/25
 * @description:
 */
public class Solution23 {

    private static class ListNode23 {
        int val;
        ListNode23 next;

        ListNode23() {
        }

        ListNode23(int val) {
            this.val = val;
        }

        ListNode23(int val, ListNode23 next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 自己版本的
     * @param lists
     * @return
     */
    public ListNode23 mergeKLists(ListNode23[] lists) {


        List<ListNode23> ls = Arrays.asList(lists);
        List<ListNode23> cc = new ArrayList<>();
        ls.forEach(listNode23 -> {
            if (null != listNode23 ){
                cc.add(listNode23);
            }
        });

        lists = cc.toArray(new ListNode23[cc.size()]);


        int len = lists.length;



        if (len == 0) {
            return null;
        }

        if (len == 1) {
            return lists[0];
        }

        // 把最小的换到第一位
        int min = lists[0].val;
        int minIndex = 0;
        for (int i = 1; i < len; i++) {
            if (lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }

        ListNode23 l = lists[minIndex];
        lists[minIndex] = lists[0];
        lists[0] = l;

        ListNode23 org = lists[0];
        for (int i = 1; i < len; i++) {
            ListNode23 res = org;
            ListNode23 ln = lists[i];
            ListNode23 pre = res;

            while (true) {
                if (ln.val >= res.val) {
                    //res 没走完的情况下
                    if (res.next != null) {
                        pre = res;
                        res = res.next;
                    } else {
                        res.next = ln;
                        break;
                    }
                } else {
                    // ln 那部分得赋值到res
                    ListNode23 sign = ln.next;
                    pre.next = ln;
                    ln.next = res;
                    pre = ln;
                    ln = sign;
                    if (ln == null) {
                        break;
                    }
                }
            }
        }
        return org;
    }


    /**
     *  使用会 自己排序的优先队列
     * @param lists
     * @return
     */
    public ListNode23 mergeKLists23_offcial(ListNode23[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode23> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode23 dummy = new ListNode23(0);
        ListNode23 p = dummy;
        for (ListNode23 node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode23 listNode23 = new ListNode23(1);
        ListNode23 listNode231 = new ListNode23(4);
        ListNode23 listNode232 = new ListNode23(5);
        listNode23.next  = listNode231;
        listNode231.next = listNode232;

        ListNode23 listNode233 = new ListNode23(1);
        listNode233.next = new ListNode23(3);
        listNode233.next.next = new ListNode23(4);


        ListNode23[] lists = new ListNode23[2];
        lists[0] = listNode23;
        lists[1] = listNode233;

        Solution23 solution23 = new Solution23();
//        ListNode23 listNode234 = solution23.mergeKLists(lists);
        ListNode23 listNode234 = solution23.mergeKLists23_offcial(lists);

        while (listNode234 != null){
            System.out.println(listNode234.val);
            listNode234 = listNode234.next;
        }

    }

}
