package com.example.leetcode.codetop;

public class Solution1124 {

    public int longestWPI(int[] hours) {

        int[] arr = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            arr[i] = (hours[i] > 8 ? -1 : 1);
        }





        return  hours.length;
    }
}
