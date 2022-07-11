package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[][] merge = new int[intervals.length][2];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];
            if (i == 0 || merge[count-1][1] < start) {
                merge[count] = new int[]{start, end};
                ++count;
            }else {
                merge[count -1][1] = Math.max(merge[count -1][1],end);
            }
        }
        int[][] res = new int[count][2];
        System.arraycopy(merge, 0, res, 0, count);

        return res;
    }

    public static void main(String[] args) {
//        int[][] intervals  = {{2,6},{1,3},{8,10},{15,18}};
        int[][] intervals = {{1, 4}, {2, 3}};
        Solution56 solution56 = new Solution56();
        solution56.merge(intervals);

    }
}
