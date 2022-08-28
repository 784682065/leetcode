package com.example.leetcode.bishi.meituan;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int t = Integer.parseInt(s1[1]);

        long count = 0;
        long res = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt() / t);
        }
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            if (list.get(i) <= count){
                res++;
            }else {
                count++;
            }
        }
        System.out.println(res);
    }

}
