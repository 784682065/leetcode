package com.example.leetcode.bishi.guanglianda;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if ((o2[0] <= o1[0] && o2[0] <= o1[1])) {
                return o2[0] - o1[0];
            } else if ((o2[1] <= o1[0] && o2[1] <= o1[1])) {
                return o2[1] - o1[0];
            } else if ((o1[1] <= o2[0] && o1[1] <= o2[1])) {
                return o1[1] - o2[0];
            } else {
                return o1[0] - o2[0];
            }
        });
        priorityQueue.add(new int[]{n, m});

        long cost = 0;
        while (k > 1) {
            while (priorityQueue.peek()[0] == 1 && priorityQueue.peek()[1] == 1) {
                priorityQueue.poll();
            }
            int[] poll = priorityQueue.poll();
            int min = Math.min(poll[0], poll[1]);
            cost += (long) min * min;
            k--;
            priorityQueue.add(new int[]{min, Math.abs(poll[0] - poll[1])});
            priorityQueue.add(poll);

        }

        System.out.println(cost);
    }
}
