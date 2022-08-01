package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.HashMap;

public class Solution567 {


    /**
     * 不管顺序的连续排列
     * 需要固定的滑动窗口
     * <p>
     * 之前做的都是不联系的移位排列,所以可以移动串口大小
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        // n为固定的滑动窗口大小
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        "hello"
//        "ooolleoooleh"
        String a = "hello";
        String b = "ooolleoooleh";
        Solution567 solution567 = new Solution567();
        boolean b1 = solution567.checkInclusion(a, b);
        System.out.println(b1);
    }

}
