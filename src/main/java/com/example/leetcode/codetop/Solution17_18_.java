package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution17_18_ {


    HashMap<Integer, Integer> smallCount;
    HashMap<Integer, Integer> bigCount;

    public int[] shortestSeq(int[] big, int[] small) {
        if (big.length < small.length)
            return new int[0];

        // 初始化计算
        smallCount = new HashMap<>();
        for (int j : small) {
            smallCount.put(j, smallCount.getOrDefault(j, 0) + 1);
        }
        bigCount = new HashMap<>();

        int left = 0, right = 0;
        int min = Integer.MAX_VALUE, leftRes = -1, rightRes = -1;
        while (right < big.length) {
            // 遇到一个减少,每次check
            if (smallCount.containsKey(big[right])) {
                bigCount.put(big[right], bigCount.getOrDefault(big[right], 0) + 1);
            }

            //开始left ++
            while (check(bigCount, smallCount)) {
                if (right - left < min) {
                    leftRes = left;
                    rightRes = right;
                    min = right - left;
                }
                if (smallCount.containsKey(big[left])) {
                    bigCount.put(big[left], bigCount.getOrDefault(big[left], 0) - 1);
                }
                ++left;
            }
            right++;
        }


        return leftRes == -1 ? new int[0] : new int[]{leftRes, rightRes};
    }

    private boolean check(HashMap<Integer, Integer> bigCount, HashMap<Integer, Integer> smallCount) {

        for (Map.Entry<Integer, Integer> integerIntegerEntry : smallCount.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            if (bigCount.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] big = {878982, 143504, 268583, 394343, 849567, 257687, 352256, 35131, 663529, 543027};
        int[] small = {143504};
        Solution17_18_ solution17_18_ = new Solution17_18_();

        int[] ints = solution17_18_.shortestSeq(big, small);
        System.out.println(Arrays.toString(ints));
    }
}
