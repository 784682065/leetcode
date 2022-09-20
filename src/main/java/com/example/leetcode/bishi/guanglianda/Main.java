package com.example.leetcode.bishi.guanglianda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            // 看有几对相邻字母是一样的 3个算两对 4个算三队这样.
            if (str.length() <= 1) {
                ans.add("No");
                continue;
            }
            int total = 0;
            StringBuilder sb = new StringBuilder(str);
            while (countTimes(sb))
                total++;

            if (total % 2 == 0) {
                ans.add("No");
            } else {
                ans.add("Yes");
            }
        }
        for (String an : ans) {
            System.out.println(an);
        }


    }

    private static boolean countTimes(StringBuilder str) {
        if (str.length() <= 1)
            return false;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) ==  str.charAt(i)){
                str.deleteCharAt(i-1);
                str.deleteCharAt(i-1);
                return true;
            }
        }
        return false;
    }

}
