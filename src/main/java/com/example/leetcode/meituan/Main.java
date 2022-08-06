package com.example.leetcode.meituan;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());

        List<List<String>> lists = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            String[] s = scanner.nextLine().split(" ");
            lists.add(Arrays.asList(s));
        }

        for (int i = 0; i < lists.size(); i++) {
            int x = Integer.parseInt(lists.get(i).get(0));
            int y = Integer.parseInt(lists.get(i).get(1));
            int min = Integer.MAX_VALUE;
            min = Math.min(x,y);
            min = Math.min(min,(x+y)/3);

            System.out.println(min);

        }
    }
}
