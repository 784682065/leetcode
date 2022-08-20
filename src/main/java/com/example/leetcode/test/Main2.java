package com.example.leetcode.test;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            map.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        String[] startArr = scanner.nextLine().split(" ");
        Deque<Integer> tripA = new ArrayDeque<>();
        int startA = Integer.parseInt(startArr[0]);
        tripA.add(startA);
        // A 去罗马的路径
        while (!tripA.contains(1)) {
            Integer peekLast = tripA.peekLast();
            if (peekLast == 1)
                break;
            tripA.add(map.get(peekLast));
        }
        // B去罗马
        Deque<Integer> tripB = new ArrayDeque<>();
        int startB = Integer.parseInt(startArr[1]);
        tripB.add(startB);
        // B 去罗马的路径
        while (true) {
            Integer peek = tripB.peekLast();
            if (tripA.contains(peek)) {
                System.out.println(peek);
                break;
            }
            // 去下一个城市
            tripB.add(map.get(peek));
        }
    }
}

