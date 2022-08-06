package com.example.leetcode.meituan;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        Map<Integer, Integer> cmap = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            list.add(num);
            cmap.put(num, cmap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> reduceMap = new HashMap<>(cmap);
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer integer = list.get(i);
            Integer ccount = cmap.get(integer);
            // 需要放入训练集中的数据个数
            int need = ccount / 2 + (ccount % 2 != 0 ? 1 : 0);

            // 加上这个还剩下的个数
            Integer rcount = reduceMap.get(integer);
            // 已经去掉的个数
            if(ccount - rcount <need){
                res1.add(i+1);
            }else {
                res2.add(i+1);
            }
            reduceMap.put(integer,rcount-1);
        }

        for (int i = 0; i < res1.size(); i++) {
            System.out.print(res1.get(i));
            if ( i != res1.size()-1){
                System.out.print(" ");
            }else {
                System.out.print("\n");
            }
        }


        for (int i = 0; i < res2.size(); i++) {
            System.out.print(res2.get(i));
            if ( i != res2.size()-1){
                System.out.print(" ");
            }
        }
    }
}


