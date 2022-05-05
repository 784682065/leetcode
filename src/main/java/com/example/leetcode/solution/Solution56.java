package com.example.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: hzp
 * @date: 2022/4/11
 * @description:
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {

        int row = intervals.length;

        if (row <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[][] tmpArr = new int[row][2];
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        int resArrPos = 0;

        for (int i = 1; i < row; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // start 比之前的 preEnd小,那就要区间合并.
            // 并且他成为新的区间
            if (start <= preEnd) {
                preEnd = Math.max(end,preEnd);
                preStart = Math.min(start,preStart);
            } else {
                tmpArr[resArrPos][0] = preStart;
                tmpArr[resArrPos][1] = preEnd;
                preStart = start;
                preEnd = end;
                resArrPos++;
            }
        }

        if (resArrPos <= row && tmpArr[resArrPos][0] == 0) {
            tmpArr[resArrPos][0] = preStart;
            tmpArr[resArrPos][1] = preEnd;
        }


        int[][] resArr = new int[resArrPos+1][2];
        for (int i = 0; i <=resArrPos; i++) {
            resArr[i ] = tmpArr[i];
        }

        return resArr;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4},{5,6}};

        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(intervals);
        System.out.println(merge);
    }


}
