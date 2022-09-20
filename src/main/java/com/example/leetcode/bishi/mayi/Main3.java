package com.example.leetcode.bishi.mayi;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        // 存放只有一个的字符
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();


        int[] dp = new int[str.length() + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i <= str.length(); i++) {
            char charAt = str.charAt(i - 1);
            int cur = 0;
            if (set1.contains(charAt)) {
                set1.remove(charAt);
                set2.add(charAt);
            } else  {
                set1.add(charAt);
            }
            if (set1.size() == 1){
                cur =1;
            }


//            else if (!set1.contains(charAt) && set2.contains(charAt)){
//
//            }
            dp[i] += dp[i - 1] + cur;
        }

        System.out.println(dp[str.length()]);
    }
}
