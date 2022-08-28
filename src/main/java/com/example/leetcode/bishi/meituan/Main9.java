package com.example.leetcode.bishi.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main9 {
    static int ans ;
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(s);
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        ans = 0;
        dfs(0,0,n);
        System.out.println(ans);
    }

    private static void dfs(int idx, int sum, int n) {
        if (idx >= n){
            ans = Math.max(ans,sum);
            return;
        }
        sum += list.get(idx);
        dfs(idx * 2 + 1, sum,n);
        dfs(idx * 2 + 2, sum,n);
        sum -= list.get(idx);
    }
}
