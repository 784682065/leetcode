package com.example.leetcode.bishi.didi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times= scanner.nextInt();
        int[] left = new int[times];
        int[] right = new int[times];
        int[] timeArr = new int[times];
        for (int i = 0; i < times; i++) {
            left[i] = scanner.nextInt();
        }
        for (int i = 0; i < times; i++) {
            right[i] = scanner.nextInt();
        }
        for (int i = 0; i < times; i++) {
            timeArr[i] = scanner.nextInt();
        }
        int[] res = new int[times];
        // 优化 0 到70000计算出所有数的美丽值,为 key 美丽值,value 为数的链表
        HashMap<Integer, LinkedList<Integer>> map = finder();
        for (int i = 0; i < times; i++) {
            int time = timeArr[i];
            LinkedList<Integer> list = map.getOrDefault(time,new LinkedList<>());
            int ans = 0;
            if (!list.isEmpty()){
                for (int i1 = 0; i1 < list.size(); i1++) {
                    if (list.get(i1)>= left[i] && list.get(i1) <= right[i]){
                        ans++;
                    } else if (list.get(i1)>= right[i]){
                        break;
                    }
                }
            }
            res[i] =ans;
        }
        for (int i = 0; i < times; i++) {
            System.out.print(res[i]+ " ");
        }
    }
    private static HashMap<Integer, LinkedList<Integer>> finder() {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i <= 70000; i++) {
            int cur = i;
            int part = cur %10;
            cur = cur/10;
            while (cur!=0) {
                part ^= (cur %10);
                cur = cur/10;
            }
            LinkedList<Integer> orDefault = map.getOrDefault(part, new LinkedList<>());
            orDefault.add(i);
            map.put(part,orDefault);
        }
        return map;
    }


}
